package com.example.cookwithpuppy.model.database.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cookwithpuppy.model.database.database.Recipe

@Dao
interface RecipeDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(recipe: Recipe)

    @Query("SELECT * FROM recipes_table ORDER BY id DESC")
    fun getAllRecipes(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipes_table WHERE id=:id")
    fun getRecipe(id: Int) : Recipe

    @Query("SELECT * FROM recipes_table WHERE recipe_isFavourite=1")
    fun getFavourites(): LiveData<List<Recipe>>

    @Update
    fun update(recipe: Recipe)

    @Delete
    fun deleteRecipe(recipe: Recipe)


}