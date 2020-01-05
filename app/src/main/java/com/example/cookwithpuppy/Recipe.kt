package com.example.cookwithpuppy

//fajnie, jakby zdjęcie by można było dodawać do przepisu, ale na razie to za dużo jest innej roboty :)
class Recipe(var id: Int, var title: String, var ingredientsList: MutableList<Char>, var stepsList: MutableList<Char>)