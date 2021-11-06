package com.lantsovapps.kotlinrecipeapp.ui

import com.lantsovapps.kotlinrecipeapp.domain.IDomain
import com.lantsovapps.kotlinrecipeapp.domain.model.Recipe

interface IView {


    fun findRecipes()
    fun setRecipes(listRecipes : ArrayList<Recipe>)
}