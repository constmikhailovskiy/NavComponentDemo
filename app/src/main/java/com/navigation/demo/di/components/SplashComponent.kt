package com.navigation.demo.di.components

import com.navigation.demo.di.modules.SplashModule
import com.navigation.demo.di.scopes.ActivityScope
import com.navigation.demo.splash.SplashActivity
import com.navigation.demo.splash.SplashFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [SplashModule::class])
interface SplashComponent {

    fun inject(splashActivity: SplashActivity)

    fun inject(splashFragment: SplashFragment)
}