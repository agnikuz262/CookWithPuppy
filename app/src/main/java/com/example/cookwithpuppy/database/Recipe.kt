package com.example.cookwithpuppy.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes_table")
data class Recipe(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,

    @ColumnInfo(name="recipe_title")
    var title: String = "t",

    @ColumnInfo(name="recipe_ingredients")
    var ingredients: MutableList<String>

)