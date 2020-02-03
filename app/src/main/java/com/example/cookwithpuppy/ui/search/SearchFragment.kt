package com.example.cookwithpuppy.ui.search

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.adapters.SearchListAdapter
import com.example.cookwithpuppy.json.ResultRecipe
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private  lateinit var adapter : SearchListAdapter

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        searchViewModel = SearchViewModel()
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onStart() {
        super.onStart()

        button_search.setOnClickListener {
            if (search_title?.text.toString() == "") {
                Toast.makeText(requireContext(), "Missing search data!", Toast.LENGTH_SHORT).show()
               } else {
//           val response = searchViewModel.getDataFromAPI(search_title?.text.toString())
//            Thread.sleep(1000)

//              static list in case of error in API

            val list = mutableListOf<ResultRecipe>()
                val recipe1 = ResultRecipe("","eggs, tomatos, onion","https://www.incredibleegg.org/recipe/basic-french-omelet/","Omelette")
                val recipe2 = ResultRecipe("","olive, tomatos","https://www.allrecipes.com/recipe/49404/juiciest-hamburgers-ever/","Hamburger")
                val recipe3 = ResultRecipe("","tortilla, red beans, tomato souce, fresh chili","https://www.jamieoliver.com/recipes/vegetables-recipes/veggie-chilli/","Chili sin carne")
                list.add(recipe1)
                list.add(recipe2)
                list.add(recipe3)
                
                adapter = SearchListAdapter(
                  list,
//                    response.listItems,
                    requireContext(), this
                )
                recycler_search.adapter = adapter
                recycler_search.layoutManager =
                    LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                val inputManager: InputMethodManager =
                    requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(
                    requireActivity().currentFocus!!.windowToken,
                    InputMethodManager.HIDE_NOT_ALWAYS
                )
            }


        }
    }
    }
