package com.navigation.demo.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.navigation.demo.NavigationDemoApp
import com.navigation.demo.R
import com.navigation.demo.di.components.HomeComponent
import com.navigation.demo.di.modules.HomeModule
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private lateinit var homeComponent: HomeComponent
    private lateinit var navListener: NavController.OnDestinationChangedListener
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeComponent = NavigationDemoApp.appComponent.homeComponent(HomeModule(this)).apply {
            inject(this@HomeActivity)
        }

        navController = findNavController(R.id.mainNavigationFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        initNavigationListener()

        navController.addOnDestinationChangedListener(navListener)
    }

    override fun onDestroy() {
        navController.removeOnDestinationChangedListener(navListener)

        super.onDestroy()
    }

    fun getHomeComponent() = homeComponent

    private fun initNavigationListener() {
        navListener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragmentEventsList, R.id.fragmentContest, R.id.fragmentNotifications -> {
                    bottomNavigationView.isVisible = true
                }
                else -> bottomNavigationView.isVisible = false
            }
        }
    }
}
