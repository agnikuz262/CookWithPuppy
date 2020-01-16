package com.example.cookwithpuppy.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.cookwithpuppy.database.Recipe

class RecipeDiffUtilCallback : DiffUtil.ItemCallback<Recipe>(){

    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }
    }