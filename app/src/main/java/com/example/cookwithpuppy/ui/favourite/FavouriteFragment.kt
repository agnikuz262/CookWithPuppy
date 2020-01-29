package com.example.cookwithpuppy.ui.favourite

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
import com.example.cookwithpuppy.adapters.MyRecipesListAdapter
import kotlinx.android.synthetic.main.fragment_favourite.*
import kotlinx.android.synthetic.main.fragment_myrecipe.*

class FavouriteFragment : Fragment() {

    private lateinit var favouriteViewModel : FavouriteViewModel
    private  lateinit var adapter : MyRecipesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favouriteViewModel = ViewModelProviders.of(this).get(FavouriteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favourite, container, false)


//        favouriteViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onStart() {
        super.onStart()

        favouriteViewModel.favouriteRecipes.observe(this,
            Observer {
        adapter = MyRecipesListAdapter(it,requireContext(),this)
        recycler_favourite.adapter = adapter
        recycler_favourite.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            })
    }
}