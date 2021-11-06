package com.lantsovapps.kotlinrecipeapp.domain

import com.lantsovapps.kotlinrecipeapp.domain.Mapper.Mapper
import com.lantsovapps.kotlinrecipeapp.domain.model.Recipe


interface IDomain {

    val mapper : Mapper


    fun networkData()
    fun viewData(array : ArrayList<Recipe>)

}