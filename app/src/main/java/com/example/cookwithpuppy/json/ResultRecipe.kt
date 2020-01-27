package com.example.cookwithpuppy.json


import com.google.gson.annotations.SerializedName


data class ResultRecipe(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("ingredients")
	val ingredients: String? = null,

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)