package com.example.cookwithpuppy.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RecipeDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipe: Recipe)

    @Query("SELECT * FROM recipes_table ORDER BY id DESC")
    fun getAllRecipes(): List<Recipe>

    @Delete
    fun delete(recipe: Recipe)


}