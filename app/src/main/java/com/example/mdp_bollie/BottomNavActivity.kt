package com.example.mdp_bollie

import android.graphics.Outline
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewOutlineProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mdp_bollie.ui.business.BusinesHubFragment
import com.example.mdp_bollie.databinding.ActivityBottomNavBinding
import com.example.mdp_bollie.ui.course.CourseHubFragment
import com.example.mdp_bollie.ui.home.HomeFragment
import com.example.mdp_bollie.ui.notifications.SettingsFragment

class BottomNavActivity : AppCompatActivity(){

    inner class shadowProvider : ViewOutlineProvider() {
        override fun getOutline(view: View?, outline: Outline?) {
            TODO("Not yet implemented")
        }
    }

    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)
         }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.navigation_home, R.id.navigation_course, R.id.navigation_businessHub, R.id.navigation_settings
                )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

}