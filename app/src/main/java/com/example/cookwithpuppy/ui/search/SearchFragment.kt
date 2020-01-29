package com.example.cookwithpuppy.ui.search

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookwithpuppy.R
import com.example.cookwithpuppy.adapters.SearchListAdapter
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
           val response = searchViewModel.getDataFromAPI(search_title?.text.toString())
            Thread.sleep(1000)
            adapter = SearchListAdapter(
                response.listItems,
                requireContext(),this)
            recycler_search.adapter = adapter
            recycler_search.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        }


    }

    }
