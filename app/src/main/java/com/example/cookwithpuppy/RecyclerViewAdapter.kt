package com.example.cookwithpuppy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.database.Recipe
import kotlinx.android.synthetic.main.recipe_data_in_recycle.view.*

class RecyclerViewAdapter(val recipes: List<Recipe>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_data_in_recycle,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = recipes[position].title
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
         val title = itemView.findViewById<TextView>(R.id.recipe_title)
    }
}