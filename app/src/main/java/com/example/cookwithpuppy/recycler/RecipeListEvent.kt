package com.example.cookwithpuppy.recycler

sealed class RecipeListEvent {
    data class OnRecipeItemClick(val position: Int) : RecipeListEvent()
    object OnNewRecipeClick : RecipeListEvent()
    object OnStart : RecipeListEvent()
}