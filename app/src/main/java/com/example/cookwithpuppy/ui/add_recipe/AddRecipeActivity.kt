package com.example.cookwithpuppy.ui.add_recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.database.Recipe
import com.example.cookwithpuppy.database.RecipeDatabase
import kotlinx.android.synthetic.main.activity_add_recipe.*

class AddRecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Add recipe")
        setContentView(R.layout.activity_add_recipe)

        val db = Room
            .databaseBuilder(applicationContext, RecipeDatabase::class.java,"RecipeDB")
            .build()

        button_add.setOnClickListener {
            if(edit_title.text == null || edit_ingredients.text == null)
                Toast.makeText(this, "Fill the data!", Toast.LENGTH_SHORT).show()
            else {
                Thread {
                    val title = edit_title.text.toString()
                    val ingredients = edit_ingredients.text.toString()


                    val recipe = Recipe(null, title, ingredients)

                    db.recipeDao().insert(recipe)

                    db.recipeDao().getAllRecipes().forEach {
                        Log.e("RECIPE", "recipe: ${it.title}")
                    }
                }.start()

            }


        }
    }
}
