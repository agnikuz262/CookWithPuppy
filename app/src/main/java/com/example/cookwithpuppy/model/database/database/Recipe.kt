package com.example.cookwithpuppy.model.database.database

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
    var ingredients: String = "",

    @ColumnInfo(name="recipe_href")
    var href: String? = "",

    @ColumnInfo(name="recipe_isFavourite")
    var isFavourite: Int = 0
)