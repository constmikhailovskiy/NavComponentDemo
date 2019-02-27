package com.navigation.demo.di.components

import com.navigation.demo.di.modules.HomeModule
import com.navigation.demo.di.scopes.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {


}