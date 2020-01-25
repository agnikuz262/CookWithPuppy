package com.example.cookwithpuppy.ui.display_recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.database.RecipeDatabase
import kotlinx.android.synthetic.main.activity_display_recipe.*

class DisplayRecipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_recipe)

        Thread {
            val db = RecipeDatabase.getInstance(applicationContext)

            val id = intent.getIntExtra("id", -1)
            val recipe = db.recipeDao().getRecipe(id)

            label_title.text = recipe.title
            list_ingredients.text = recipe.ingredients
            href.text = "lalala"
        }.start()

        button_cancel.setOnClickListener {
            this.finish()
        }
    }
}
