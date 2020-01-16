package com.example.cookwithpuppy.ui.myrecipes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cookwithpuppy.database.Recipe
import com.example.cookwithpuppy.database.RecipeDatabase

class MyRecipesViewModel(application: Application) : AndroidViewModel(application) {

    private val db: RecipeDatabase = RecipeDatabase.getInstance(application)



    var allRecipes: LiveData<List<Recipe>> = db.recipeDao().getAllRecipes()


}