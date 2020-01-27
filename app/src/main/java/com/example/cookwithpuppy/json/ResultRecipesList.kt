package com.example.cookwithpuppy.json

import com.google.gson.annotations.SerializedName

class ResultRecipesList {
    @SerializedName("results")
    var listItems: List<ResultRecipe?>? = null
}