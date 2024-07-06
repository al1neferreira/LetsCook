package com.example.letscook.model.recipe

@kotlinx.serialization.Serializable
data class RecipeResponse(
    val recipes: List<RecipeDto>
)