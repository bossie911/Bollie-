package com.example.mdp_bollie

import android.graphics.Outline
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
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
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val homeFragment = HomeFragment()
        val courseHubFragment = CourseHubFragment()
        val businesHubFragment = BusinesHubFragment()
        val settingsFragment = SettingsFragment()
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_courses, R.id.navigation_business, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.navigation_home -> {
                    makeCurrentFragment(homeFragment)
                }
                R.id.navigation_business ->{
                    makeCurrentFragment(businesHubFragment)
                }
                R.id.navigation_courses ->{
                    makeCurrentFragment(courseHubFragment)
                }
                R.id.navigation_profile ->{
                    makeCurrentFragment(settingsFragment)
                }
            }
            false
        }
        binding.navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }
    private fun makeCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply{
        replace(R.id.nav_host_fragment, fragment)
        commit()
    }
}