package com.example.cookwithpuppy.json


import com.google.gson.annotations.SerializedName


data class Result(

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("version")
	val version: Double? = null,

	@field:SerializedName("results")
	val results: List<ResultRecipe?>? = null
)