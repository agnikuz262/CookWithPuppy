package com.example.cookwithpuppy.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cookwithpuppy.json.ResultRecipesList
import com.example.cookwithpuppy.json.Result
import com.example.cookwithpuppy.model.database.APIconnection
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class SearchViewModel : ViewModel() {

    private var searchedList = ResultRecipesList().listItems


//    fun getDataFromAPI(typedSearch: String): ResultRecipesList {
//        val dataFromApi = APIconnection().listFromAPI(typedSearch)
//
//        return dataFromApi
//    }

}