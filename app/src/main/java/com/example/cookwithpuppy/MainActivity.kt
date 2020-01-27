package com.example.cookwithpuppy

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.cookwithpuppy.database.RecipeDatabase
import com.example.cookwithpuppy.ui.AboutActivity
import com.example.cookwithpuppy.ui.add_recipe.AddRecipeActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //createDB()

        val fab: FloatingActionButton = findViewById(R.id.float_button_add)
        fab.setOnClickListener {

            val intent = Intent(this, AddRecipeActivity::class.java).apply {}
            this.startActivity(intent)

        }


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_myrecipe, R.id.nav_search, R.id.nav_favourite,
                R.id.nav_tools
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java).apply {
                }
                this.startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun createDB() {
        val db = Room
            .databaseBuilder(applicationContext, RecipeDatabase::class.java,"RecipeDB")
            .build()
    }
}
