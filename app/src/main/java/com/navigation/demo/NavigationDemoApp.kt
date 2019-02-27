package com.navigation.demo

import android.app.Application
import com.navigation.demo.di.components.AppComponent
import com.navigation.demo.di.modules.AppModule
import com.navigation.demo.di.components.DaggerAppComponent

class NavigationDemoApp : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}