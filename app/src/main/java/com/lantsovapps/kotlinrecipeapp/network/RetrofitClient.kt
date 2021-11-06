package com.lantsovapps.kotlinrecipeapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private var client : Retrofit? = null

    fun getClient(url:String) :Retrofit {
        if(client == null){
            client = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return client!!
    }
}