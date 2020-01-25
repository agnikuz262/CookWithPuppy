package com.example.cookwithpuppy.json

import androidx.lifecycle.LiveData
import com.google.gson.annotations.SerializedName

class FoundRecipesList {
    @SerializedName("results")
    var listItems: LiveData<List<FoundRecipe>>? = null
}