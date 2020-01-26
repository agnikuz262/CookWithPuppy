package com.example.cookwithpuppy.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface RecipeDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipe: Recipe)

    @Query("SELECT * FROM recipes_table ORDER BY id DESC")
    fun getAllRecipes(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipes_table WHERE id=:id")
    fun getRecipe(id: Int) : Recipe

    @Delete
    fun deleteRecipe(recipe: Recipe)


}