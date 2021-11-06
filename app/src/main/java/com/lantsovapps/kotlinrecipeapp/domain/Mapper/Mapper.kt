package com.lantsovapps.kotlinrecipeapp.domain.Mapper

import com.lantsovapps.kotlinrecipeapp.domain.model.Recipe
import com.lantsovapps.kotlinrecipeapp.network.model.RecipeDTO

class Mapper : IMapper<RecipeDTO, Recipe>{

    private val noImg = "https://1080motion.com/wp-content/uploads/2018/06/NoImageFound.jpg.png"
    override fun mapFromDTO(input: RecipeDTO): Recipe {
        return Recipe(
            id = input.id?: 0,
            title = input.title?:"No title",
            image = input.image?:noImg,
            likes = input.likes?:0
        )
    }

    override fun mapFromDomain(input: Recipe): RecipeDTO {
        return RecipeDTO(
            id = input.id,
            title = input.title,
            image = input.image,
            likes = input.likes
        )
    }
}