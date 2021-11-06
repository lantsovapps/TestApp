package com.lantsovapps.kotlinrecipeapp.network

import com.lantsovapps.kotlinrecipeapp.network.model.RecipeDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMyApi {
    @GET("findByIngredients")
    fun getRecipes(
        @Query("apiKey") apiKey: String,
        @Query("ingredients") ingredients: String,
        @Query("number") number: Int
    ) : Call<ArrayList<RecipeDTO>>
}