package com.example.cookwithpuppy.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.database.Recipe

class RecyclerViewAdapter(val event: MutableLiveData<RecipeListEvent> =
    MutableLiveData()): ListAdapter<Recipe, RecyclerViewAdapter.ViewHolder>(RecipeDiffUtilCallback())
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_data_in_recycle,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        getItem(position).let { recipe ->
            holder.title.text = recipe.title


            holder.itemView.setOnClickListener {
                event.value = RecipeListEvent.OnRecipeItemClick(position)
            }
        }
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
         val title = itemView.findViewById<TextView>(R.id.recipe_title)
    }
}