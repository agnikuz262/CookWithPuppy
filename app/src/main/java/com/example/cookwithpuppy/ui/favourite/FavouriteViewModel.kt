package com.example.cookwithpuppy.ui.favourite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cookwithpuppy.model.database.database.Recipe
import com.example.cookwithpuppy.model.database.database.RecipeDatabase

class FavouriteViewModel(application: Application) : AndroidViewModel(application){

    private val db: RecipeDatabase = RecipeDatabase.getInstance(application)
    var favouriteRecipes: LiveData<List<Recipe>> = db.recipeDao().getFavourites()
}