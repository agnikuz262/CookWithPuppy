package com.example.cookwithpuppy.ui.display_recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cookwithpuppy.R
import kotlinx.android.synthetic.main.activity_display_recipe.*

class DisplaySearchRecipe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_search_recipe)

        val recipeTitle = intent.getStringExtra("title")
        val recipeIngredients = intent.getStringExtra("ingredients")
        val recipeHref = intent.getStringExtra("href")


        label_title.text = recipeTitle
        list_ingredients.text = recipeIngredients
        href.text = recipeHref
    }
}
