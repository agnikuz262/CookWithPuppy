package com.example.cookwithpuppy.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.MainActivity
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.database.Recipe
import com.example.cookwithpuppy.ui.display_recipe.DisplayMyRecipe

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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val recipe = recipes[position]
        holder.title.text = recipe.title

        holder.singleRecipe.setOnClickListener {
            val intent = Intent(context, DisplayMyRecipe::class.java).apply {
                putExtra("id", recipe.id) }
            (context as MainActivity).startActivity(intent)
        }
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.recipe_title)
        val singleRecipe = itemView.findViewById<LinearLayout>(R.id.singe_recipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}