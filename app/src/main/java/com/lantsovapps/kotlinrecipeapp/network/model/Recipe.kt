package com.lantsovapps.kotlinrecipeapp.network.model

import com.google.gson.annotations.SerializedName

data class RecipeDTO(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("likes")
    val likes: Int?
)
