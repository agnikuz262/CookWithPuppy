package com.example.cookwithpuppy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.json.ResultRecipe


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
    }


    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.recipe_title)
    }

    override fun getItemCount(): Int {
        return if (recipes == null) 0 else recipes.size
    }


}