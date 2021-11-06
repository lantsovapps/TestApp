package com.lantsovapps.kotlinrecipeapp.network

import com.lantsovapps.kotlinrecipeapp.domain.Domain
import com.lantsovapps.kotlinrecipeapp.network.model.RecipeDTO
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Network(domain: Domain) : INetwork{
    private val BASE_URL : String = "https://api.spoonacular.com/recipes/"
    val Api_Key : String = "YOUR_API_KEY"
    val FOOD : String = "avocado"
    val client : Retrofit = RetrofitClient().getClient(BASE_URL)
    val myApi : IMyApi = client.create(IMyApi::class.java)
    val myDomain = domain

    override fun getData(apiKey:String,
                ingredients: String,
                number:Int) {
        lateinit var list : ArrayList<RecipeDTO>
        CoroutineScope(IO).launch {
            val result : Deferred<ArrayList<RecipeDTO>> = async {
                getRecipeArrayList(apiKey, ingredients, number)
            }
            list = result.await()
            println("debug: get Data size: ${list.size}")
            withContext(Main) {
                myDomain.prepareData(list)
            }
        }


    }

   private suspend fun getRecipeArrayList(
        apiKey:String,
        ingredients: String,
        number:Int
    ) : ArrayList<RecipeDTO> {
        return suspendCoroutine { continuation ->
            myApi.getRecipes(apiKey,ingredients,number)
                .enqueue(object : Callback<ArrayList<RecipeDTO>>{
                    override fun onFailure(call: Call<ArrayList<RecipeDTO>>, t: Throwable) {
                        myDomain.viewError()
                    }
                    override fun onResponse(
                        call: Call<ArrayList<RecipeDTO>>,
                        response: Response<ArrayList<RecipeDTO>>
                    ) {
                        println("debug: onResponse")
                        continuation.resume(response.body() as ArrayList<RecipeDTO>)
                    }

                })
        }
    }
}
