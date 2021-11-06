package com.lantsovapps.kotlinrecipeapp.domain.Mapper

interface IMapper <RecipeDTO, Recipe>{
    fun mapFromDTO(input: RecipeDTO) : Recipe
    fun mapFromDomain(input: Recipe) : RecipeDTO
}