package com.lantsovapps.kotlinrecipeapp.domain


import com.lantsovapps.kotlinrecipeapp.domain.Mapper.Mapper
import com.lantsovapps.kotlinrecipeapp.domain.model.Recipe

import com.lantsovapps.kotlinrecipeapp.network.Network
import com.lantsovapps.kotlinrecipeapp.network.model.RecipeDTO

import com.lantsovapps.kotlinrecipeapp.ui.MainActivity

class Domain (view: MainActivity): IDomain {

    override val mapper: Mapper = Mapper()
    private val myNetwork : Network = Network(this)
    private val myView = view

    override fun networkData(){
        myNetwork.getData(myNetwork.Api_Key, myNetwork.FOOD, (5..25).random())
    }

    fun prepareData(array : ArrayList<RecipeDTO>) {
        val arrayDomain : ArrayList<Recipe> = ArrayList()
        for (recipeDTO in array){
            arrayDomain.add(mapper.mapFromDTO(recipeDTO))
        }
        viewData(arrayDomain)
    }

    override fun viewData(array : ArrayList<Recipe>) {
        println("debug: in ViewData: ${array.size}")
        myView.setRecipes(array)
    }

    fun viewError(){
        myView.showErrorToast()
    }
}