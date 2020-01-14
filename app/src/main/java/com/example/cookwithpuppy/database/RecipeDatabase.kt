package com.example.cookwithpuppy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDatabaseDao

  //  abstract val recipeDatabaseDao: RecipeDatabaseDao
//    companion object {
//
//        @Volatile
//        private var INSTANCE: RecipeDatabase? = null
//
//        fun getInstance(context: Context): RecipeDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        RecipeDatabase::class.java,
//                        "recipes_history_database"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
    }
