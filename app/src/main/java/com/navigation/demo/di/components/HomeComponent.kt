package com.navigation.demo.di.components

import com.navigation.demo.di.modules.HomeModule
import com.navigation.demo.di.scopes.ActivityScope
import com.navigation.demo.home.HomeActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {

    fun contestComponent(): ContestComponent

    fun inject(activity: HomeActivity)
}