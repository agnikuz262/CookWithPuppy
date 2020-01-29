package com.example.cookwithpuppy.ui.add_recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.model.database.database.Recipe
import com.example.cookwithpuppy.model.database.database.RecipeDatabase
import kotlinx.android.synthetic.main.activity_add_recipe.*

class AddRecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Add recipe")
        setContentView(R.layout.activity_add_recipe)

        val db = RecipeDatabase.getInstance(applicationContext)

        button_add.setOnClickListener {
            if(edit_title.text.toString() == "" || edit_ingredients.text.toString() == "")
                Toast.makeText(this, "Fill the data!", Toast.LENGTH_SHORT).show()
            else {
                Thread {
                    val title = edit_title.text.toString()
                    val ingredients = edit_ingredients.text.toString()
                    val recipe = Recipe(null, title, ingredients, null, 0)
                    db.recipeDao().insert(recipe)

                }.start()
                this.finish()
            }


        }
    }
}
