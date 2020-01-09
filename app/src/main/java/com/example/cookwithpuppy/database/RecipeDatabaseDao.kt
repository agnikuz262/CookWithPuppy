package com.example.cookwithpuppy.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDatabaseDao {

    @Insert
    fun insert(recipe: Recipe)

    @Delete
    fun delete(recipe: Recipe)

    @Query("SELECT * FROM recipes_table ORDER BY id DESC")
    fun getAllRecipes(): LiveData<List<Recipe>>
}