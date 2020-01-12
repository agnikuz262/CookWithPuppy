package com.example.cookwithpuppy.ui.search

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cookwithpuppy.R


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
        searchRecipesList.setText("haha")

        val typedSearch: EditText? = root.findViewById(R.id.search_title)
        val url: String =  "tu bedzie sie ustawialo url w opraciu o typedSearch, np.https://recipe-puppy.p.rapidapi.com/?p=1&i=chicken&q=chicken"
//
//          API
//        try {
//            run(url, searchRecipesList.toString())
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }

        searchViewModel.text.observe(this, Observer {
            searchRecipesList?.text = it
        })
        return root
    }
}
//    //API
//    @RequiresApi(Build.VERSION_CODES.N)
//    @Throws(IOException::class)
//    fun run(url: String, listOfRecipes: String) {
//
//        val client = OkHttpClient()
//        val request = Request.Builder()
//            .url(url)
//            .get()
//            .addHeader("x-rapidapi-host", "recipe-puppy.p.rapidapi.com")
//            .addHeader("x-rapidapi-key", "0232ddbd88msh2d14a4a79c195a6p11507ejsn2fbd948c70f1")
//            .build()
//
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException?) {
//                call.cancel()
//                Log.e("Failure: ", e.toString())
//
//            }
//
//            @Throws(IOException::class)
//            override fun onResponse(call: Call?, response: Response) {
//                val myResponse: String = response.body().string()
//                runOnUiThread {
//                    Log.e("Response:", myResponse)
//                    listOfRecipes.setText(myResponse)
//
//                }
//            }
//        })
