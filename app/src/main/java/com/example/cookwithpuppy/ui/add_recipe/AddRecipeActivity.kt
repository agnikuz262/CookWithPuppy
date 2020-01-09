package com.example.cookwithpuppy.ui.add_recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.database.Recipe
import kotlinx.android.synthetic.main.activity_add_recipe.*

class AddRecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        button_add.setOnClickListener {
            if(edit_title.text == null || edit_ingredients.text == null)
                Toast.makeText(this, "Fill the data!", Toast.LENGTH_SHORT).show()
            else {
                val title = edit_title.text.toString()
                val written_ingredients = edit_ingredients.text.toString()
                val ingredients = written_ingredients.split(",".toRegex()).toMutableList()

            }


        }
    }
}
