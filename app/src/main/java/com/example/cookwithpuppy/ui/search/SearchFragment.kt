package com.example.cookwithpuppy.ui.search

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.json.FoundRecipesList
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_search.*
import okhttp3.*
import java.io.IOException


class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProviders.of(this).get(SearchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_search, container, false)

        val searchRecipesList: TextView = root.findViewById(R.id.list_searched_recipes)

        val typedSearch: EditText? = root.findViewById(R.id.search_title)



        //searchViewModel.apiConnection(typedSearch?.text.toString())

        searchViewModel.text.observe(this, Observer {
            searchRecipesList.text = it
        })


        return root
    }


    }
