package com.lantsovapps.kotlinrecipeapp.network

import com.lantsovapps.kotlinrecipeapp.network.model.RecipeDTO

interface INetwork {

    fun getData(apiKey:String,
                ingredients: String,
                number:Int)
}