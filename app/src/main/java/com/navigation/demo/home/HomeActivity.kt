package com.navigation.demo.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.navigation.demo.NavigationDemoApp
import com.navigation.demo.R
import com.navigation.demo.di.components.HomeComponent
import com.navigation.demo.di.modules.HomeModule
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private lateinit var homeComponent: HomeComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeComponent = NavigationDemoApp.appComponent.homeComponent(HomeModule(this)).apply {
            inject(this@HomeActivity)
        }

        val navController = findNavController(R.id.mainNavigationFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    fun getHomeComponent() = homeComponent
}
