package com.example.memesansar

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close)

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this);


        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
         var menuInflater : MenuInflater = menuInflater
        menuInflater.inflate(R.menu.toolbarmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if (id==R.id.download) {
            Toast.makeText(this,"Download Clicked",Toast.LENGTH_SHORT).show()
        }

        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var idItem = item.itemId
        if (idItem==R.id.nav_account) {
            Toast.makeText(this,"Account Clicked",Toast.LENGTH_SHORT).show()
        }
        if (idItem==R.id.nav_logout) {
            Toast.makeText(this,"Logout Clicked",Toast.LENGTH_SHORT).show()
        }
        if (idItem==R.id.nav_settings) {
            Toast.makeText(this,"Setting Clicked",Toast.LENGTH_SHORT).show()
        }
        return true
    }


}

