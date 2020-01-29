package com.example.cookwithpuppy.ui.display_recipe

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.model.database.database.Recipe
import com.example.cookwithpuppy.model.database.database.RecipeDatabase
import kotlinx.android.synthetic.main.activity_display_recipe.*


class DisplayMyRecipe : AppCompatActivity() {

    private lateinit var recipe : Recipe

     inner class DeleteTask : AsyncTask<Void,Void,String>()
    {
        override fun doInBackground(vararg params: Void?): String {
            try {
                val db = RecipeDatabase.getInstance(applicationContext)
                val id = intent.getIntExtra("id", -1)
                recipe = db.recipeDao().getRecipe(id)
                db.recipeDao().deleteRecipe(recipe)
            }catch (e: Exception) {
                Log.e("Error", e.localizedMessage)
            }
            return "Recipe deleted"
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_recipe)

        Thread {
            val db = RecipeDatabase.getInstance(applicationContext)

            val id = intent.getIntExtra("id", -1)
            recipe = db.recipeDao().getRecipe(id)

            label_title.setText(recipe.title)
            list_ingredients.setText(recipe.ingredients)
            href.setText(recipe.href)

        }.start()


        button_delete.setOnClickListener {

            val deleteAlert = AlertDialog.Builder(this)
            deleteAlert.setTitle("Delete recipe")
            deleteAlert.setMessage("Are you sure you want to delete this recipe?")

            deleteAlert.setPositiveButton(android.R.string.yes) { dialog, which ->
                DeleteTask().execute()
                Toast.makeText(applicationContext,
                    "Recipe deleted", Toast.LENGTH_SHORT).show()
                this.finish()
            }

            deleteAlert.setNegativeButton("Cancel") { _, _ -> }

            deleteAlert.show()


        }

        button_update.setOnClickListener {

            Thread {
                val db = RecipeDatabase.getInstance(applicationContext)

                val id = intent.getIntExtra("id", -1)
                recipe = db.recipeDao().getRecipe(id)
                recipe.title = label_title.text.toString()
                recipe.ingredients = list_ingredients.text.toString()
                recipe.href = href.text.toString()
                db.recipeDao().update(recipe)

            }.start()

            Toast.makeText(applicationContext,
                "Recipe updated", Toast.LENGTH_SHORT).show()
        }


    }
}
