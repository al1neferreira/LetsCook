package com.example.letscook.data.remote

import com.example.letscook.model.recipe.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET

interface RecipeService {

    @GET("recipes/random")
    fun getRandomRecipes(): Call<RecipeResponse>
}