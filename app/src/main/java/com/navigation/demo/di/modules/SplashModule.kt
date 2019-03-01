package com.navigation.demo.di.modules

import com.navigation.demo.di.scopes.ActivityScope
import com.navigation.demo.splash.SplashCoordinator
import com.navigation.demo.splash.SplashNavigator
import com.navigation.demo.splash.SplashNavigatorImpl
import dagger.Module
import dagger.Provides

@Module
class SplashModule(private val navigator: SplashNavigatorImpl) {

    @Provides
    @ActivityScope
    fun provideCoordinator(): SplashCoordinator {
        return SplashCoordinator(navigator)
    }

    @Provides
    @ActivityScope
    fun provideNavigator(): SplashNavigator = navigator
}
