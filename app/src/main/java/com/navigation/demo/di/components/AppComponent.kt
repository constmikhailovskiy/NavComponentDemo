package com.navigation.demo.di.components

import com.navigation.demo.di.modules.AppModule
import com.navigation.demo.di.modules.SplashModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun splashComponent(module: SplashModule): SplashComponent

    fun onboardingComponent(): OnboardingComponent

    fun homeComponent(): HomeComponent
}
