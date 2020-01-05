package com.example.cookwithpuppy

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.contentValuesOf

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    companion object {
        internal const val DATABASE_NAME = "recipes.db"
        internal const val DATABASE_VERSION = 1
        internal const val TABLE_NAME = "recipes"
        internal const val COL_id = "id"
        internal const val COL_title = "title"
        internal const val COL_ingredients = "ingredients"
        internal const val COL_steps = "steps"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME(" +
                    "$COL_id INTEGER PRIMARY KEY," +
                    "$COL_title TEXT NOT NULL," +
                    "$COL_ingredients TEXT NOT NULL," +
                    "$COL_steps TEXT NOT NULL)"
        )

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    val allRecipes: MutableList<Recipe>
        get() {

            val query = "SELECT * FROM $TABLE_NAME"
            val recipes = mutableListOf<Recipe>()
            val db = this.readableDatabase
            val cursor = db.rawQuery(query, null)

            if (cursor.moveToFirst()) {
                do {
                    val id = cursor.getInt(cursor.getColumnIndex(COL_id))
                    val title = cursor.getString(cursor.getColumnIndex(COL_title))
                    val ingredients = cursor.getString(cursor.getColumnIndex(COL_ingredients))
                    val steps = cursor.getString(cursor.getColumnIndex(COL_steps))
                    val recipe = Recipe(id, title, ingredients.toMutableList(), steps.toMutableList())
                    recipes.add(recipe)
                } while (cursor.moveToNext())
            }
            cursor.close()
            db.close()

            return recipes
        }

    fun addRecipe(recipe: Recipe): Long {

        val db = this.writableDatabase
        val value = contentValuesOf()
        value.put(COL_title, recipe.title)
        value.put(COL_ingredients, recipe.ingredientsList.toString())
        value.put(COL_steps, recipe.stepsList.toString())
        val result = db.insert(TABLE_NAME, null, value)
        recipe.id = result.toInt()
        db.close()
        return result

    }

    fun deleteRecipe(id: Int?): Int {

        val db = this.writableDatabase
        var result = db.delete(TABLE_NAME, "$COL_id=?", arrayOf(id.toString()))
        db.close()
        return result
    }

}