package com.example.cookwithpuppy.ui.myrecipes

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.MainActivity
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.adapters.MyRecipesListAdapter
import com.example.cookwithpuppy.ui.add_recipe.AddRecipeActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_myrecipe.*


class MyRecipesFragment : Fragment() {

    private lateinit var myRecipesViewModel: MyRecipesViewModel
    private  lateinit var adapter : MyRecipesListAdapter

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myRecipesViewModel = ViewModelProviders.of(this).get(MyRecipesViewModel::class.java)

       val view = inflater.inflate(R.layout.fragment_myrecipe, container, false)
       val fab : FloatingActionButton = view.findViewById(R.id.float_button_add)

        fab.setOnClickListener {
            val intent = Intent(requireContext(), AddRecipeActivity::class.java).apply {}
            this.startActivity(intent)
        }

       return view
    }

    override fun onStart() {
        super.onStart()

        myRecipesViewModel.allRecipes.observe(this,
            Observer {

                adapter = MyRecipesListAdapter(it,requireContext(),this)
                recycler_myrecipes.adapter = adapter
                recycler_myrecipes.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            })
    }


    override fun onDestroyView() {
        super.onDestroyView()

        recycler_myrecipes.adapter = null

    }

}
