package com.example.cookwithpuppy.ui.myrecipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.RecyclerViewAdapter
import com.example.cookwithpuppy.database.Recipe
import kotlinx.android.synthetic.main.fragment_myrecipe.*
import java.util.*

class MyRecipesFragment : Fragment() {

    private lateinit var myRecipesViewModel: MyRecipesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myRecipesViewModel =
            ViewModelProviders.of(this).get(MyRecipesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_myrecipe, container, false)

        val textView: TextView = root.findViewById(R.id.text_myrecipe)
        myRecipesViewModel.text.observe(this, Observer {
            textView.text = it
        })

//        val linearLayoutManager = LinearLayoutManager(
//            requireContext(), RecyclerView.VERTICAL,false)
//        recycler_myrecipes.layoutManager = linearLayoutManager
//
//
//        myRecipesViewModel.allRecipes.observe(this, Observer { recipes ->
//
//            recycler_myrecipes.adapter = RecyclerViewAdapter(recipes)
//        })



        return root
    }
}