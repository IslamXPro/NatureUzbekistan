package com.example.natureuzbekistan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.natureuzbekistan.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

/*        binding.apply {
            homeBtn.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        HomeFragment::class.java
                    )
                )
            }
            searchBtn.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        SearchFragment::class.java
                    )
                )
            }
            addBtn.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        AddFragment::class.java
                    )
                )
            }
            favouriteBtn.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        FavouriteFragment::class.java
                    )
                )
            }
            accountBtn.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        AccountFragment::class.java
                    )
                )
            }
        }*/

/*        binding.navView.setNavigationItemSelectedListener(this)*/

    }
    /*  override fun onNavigationItemSelected(item: MenuItem): Boolean {
          when (item.itemId) {
              R.id.home_id ->{
                  Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
              }
              R.id.search_id -> {
                  startActivity(Intent(this,SearchFragment::class.java))
              }
              R.id.add_id -> {
                  startActivity(Intent(this,AddFragment::class.java))
              }
              R.id.favourite_id -> {
                  startActivity(Intent(this,FavouriteFragment::class.java))
              }
              R.id.profile_id -> {
                  startActivity(Intent(this,AccountFragment::class.java))
              }
          }
          return true
      }*/
}