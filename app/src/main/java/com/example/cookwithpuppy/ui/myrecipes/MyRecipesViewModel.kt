package com.example.cookwithpuppy.ui.myrecipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyRecipesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is my recipes Fragment"
    }
    val text: LiveData<String> = _text
}