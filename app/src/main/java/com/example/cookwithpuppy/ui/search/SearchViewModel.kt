package com.example.cookwithpuppy.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cookwithpuppy.database.Recipe
import com.example.cookwithpuppy.json.FoundRecipe
import com.example.cookwithpuppy.json.FoundRecipesList
import com.example.cookwithpuppy.json.LaLa
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class SearchViewModel : ViewModel() {

    private var searchedRecipesList = FoundRecipesList()

    //API
    fun apiConnection(typedSearch: String) /*: FoundRecipesList*/ {

        var tableSearch = typedSearch.split(" ".toRegex())

        var url =  "https://recipe-puppy.p.rapidapi.com/?p=1&q="
        for(i in 0 until tableSearch.size-1)
            url += tableSearch[i] + "%20"
        url += tableSearch[tableSearch.size-1]


        try {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .get()
                .addHeader("x-rapidapi-host", "recipe-puppy.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "0232ddbd88msh2d14a4a79c195a6p11507ejsn2fbd948c70f1")
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException?) {
                    call.cancel()
                    Log.e("Failure: ", e.toString())
                }

                @Throws(IOException::class)
                override fun onResponse(call: Call?, response: Response) {
                    val myResponse = response.body().toString()
                    var gson = Gson()
                    val data = gson.fromJson(myResponse, LaLa::class.java)
                    //searchedRecipesList = data
                }

            })

        } catch (e: IOException) {
            e.printStackTrace()
        }

//        return searchedRecipesList!!
    }

}