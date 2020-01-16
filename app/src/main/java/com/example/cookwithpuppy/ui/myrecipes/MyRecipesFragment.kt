package com.example.cookwithpuppy.ui.myrecipes

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.recycler.RecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_myrecipe.*


class MyRecipesFragment : Fragment() {

    private lateinit var myRecipesViewModel: MyRecipesViewModel
    private  lateinit var adapter : RecyclerViewAdapter

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.fragment_myrecipe, container, false)
    }

    override fun onStart() {
        super.onStart()
        
    }

    override fun onDestroyView() {
        super.onDestroyView()

        recycler_myrecipes.adapter = null
    }


}

//    fun setRecycle() {
//        recycler_myrecipes.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
//        var adapter =
//            RecyclerViewAdapter(db.recipeDao().getAllRecipes())
//        recycler_myrecipes.adapter = adapter
//    }
//}