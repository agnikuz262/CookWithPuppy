package com.example.cookwithpuppy.ui.display_recipe

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.database.Recipe
import com.example.cookwithpuppy.database.RecipeDatabase
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

            label_title.text = recipe.title
            list_ingredients.text = recipe.ingredients

        }.start()

        button_cancel.setOnClickListener {
            this.finish()
        }

        button_delete.setOnClickListener {

            val deleteAlert = AlertDialog.Builder(this)
            deleteAlert.setTitle("Delete recipe")
            deleteAlert.setMessage("Are you sure to delete this recipe?")

            deleteAlert.setPositiveButton(android.R.string.yes) { dialog, which ->
                DeleteTask().execute()
                Toast.makeText(applicationContext,
                    "Recipe deleted", Toast.LENGTH_SHORT).show()
                this.finish()
            }

            deleteAlert.setNegativeButton("Cancel") { dialog, which ->
                           }

            deleteAlert.show()


        }


    }
}
