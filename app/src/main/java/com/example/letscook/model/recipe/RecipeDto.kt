package com.example.letscook.model.recipe

data class RecipeDto(
    val id: Int,
    val title: String,
    val summary: String,
    val image: String,
    val imageType: String
)