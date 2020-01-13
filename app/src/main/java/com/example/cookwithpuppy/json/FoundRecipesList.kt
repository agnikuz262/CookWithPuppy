package com.example.cookwithpuppy.json

import com.google.gson.annotations.SerializedName

class FoundRecipesList {
    @SerializedName("results")
    var listItems: List<FoundRecipe>? = null
}