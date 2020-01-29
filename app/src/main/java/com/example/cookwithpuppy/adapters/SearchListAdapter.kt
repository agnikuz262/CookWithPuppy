package com.example.cookwithpuppy.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.MainActivity
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.model.database.database.Recipe
import com.example.cookwithpuppy.model.database.database.RecipeDatabase
import com.example.cookwithpuppy.json.ResultRecipe
import com.example.cookwithpuppy.ui.display_recipe.DisplaySearchRecipe


class SearchListAdapter(val recipes: List<ResultRecipe?>?,
                           val context: Context,
                           val fragment: Fragment)
    : RecyclerView.Adapter<SearchListAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.data_in_search,parent,false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes!![position]!!
        holder.title.text = recipe.title

        holder.buttonAdd.setOnClickListener {
            //add to db
            Thread {
                val db = RecipeDatabase.getInstance(context)

                val insertRecipe =
                    Recipe(
                        null,
                        recipe.title!!,
                        recipe.ingredients!!
                    )
                db.recipeDao().insert(insertRecipe)

            }.start()
            Toast.makeText(context, "Recipe added", Toast.LENGTH_SHORT).show()
        }

        holder.singleRecipe.setOnClickListener {
            val intent = Intent(context, DisplaySearchRecipe::class.java).apply {
               putExtra("title", recipe.title)
               putExtra("ingredients", recipe.ingredients)
               putExtra("href", recipe.href)
                }
            (context as MainActivity).startActivity(intent)
              }
    }


    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.recipe_title)
        val buttonAdd = itemView.findViewById<Button>(R.id.button_add_to_myrecipe)
        val singleRecipe = itemView.findViewById<LinearLayout>(R.id.singe_recipe)
    }

    override fun getItemCount(): Int {
        return if (recipes == null) 0 else recipes.size
    }


}