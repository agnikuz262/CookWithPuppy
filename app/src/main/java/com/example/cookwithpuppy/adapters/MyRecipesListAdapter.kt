package com.example.cookwithpuppy.adapters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.MainActivity
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.model.database.database.Recipe
import com.example.cookwithpuppy.model.database.database.RecipeDatabase
import com.example.cookwithpuppy.ui.display_recipe.DisplayMyRecipe
import kotlinx.android.synthetic.main.data_in_myrecipe.*


class MyRecipesListAdapter(val recipes: List<Recipe>,
                           val context: Context,
                           val fragment: Fragment)
    : RecyclerView.Adapter<MyRecipesListAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.data_in_myrecipe,parent,false)
        return ViewHolder(v)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val recipe = recipes[position]
        holder.title.text = recipe.title
        when (recipe.isFavourite) {
            1 -> { holder.buttonFavourite.setImageDrawable(context.getDrawable(R.drawable.ic_star_clicked))
            }
            else -> {
            }
        }
        holder.singleRecipe.setOnClickListener {
            val intent = Intent(context, DisplayMyRecipe::class.java).apply {
                putExtra("id", recipe.id) }
            (context as MainActivity).startActivity(intent)
        }

        holder.buttonFavourite.setOnClickListener {

            Thread {

                val db = RecipeDatabase.getInstance(context)
                recipe.isFavourite = 1
                db.recipeDao().update(recipe)

            }.start()
            Toast.makeText(context, "Recipe added to Favourites", Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.recipe_title)
        val singleRecipe = itemView.findViewById<LinearLayout>(R.id.singe_recipe)
        val buttonFavourite = itemView.findViewById<ImageButton>(R.id.favorite_button)

    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}