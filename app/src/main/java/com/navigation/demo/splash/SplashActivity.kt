package com.navigation.demo.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.navigation.demo.NavigationDemoApp
import com.navigation.demo.R
import com.navigation.demo.di.components.SplashComponent
import com.navigation.demo.di.modules.SplashModule

class SplashActivity : AppCompatActivity() {

    private lateinit var component: SplashComponent
    private val navigator: SplashNavigator = SplashNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        component = NavigationDemoApp.appComponent.splashComponent(SplashModule(navigator))
        component.inject(this)

        navigator.activity = this
    }

    override fun onDestroy() {
        navigator.activity = null

        super.onDestroy()
    }

    val splashComponent: SplashComponent
        get() = component
}
