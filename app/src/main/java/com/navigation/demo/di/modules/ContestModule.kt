package com.navigation.demo.di.modules

import com.navigation.demo.home.contest.ContestCoordinator
import com.navigation.demo.home.contest.ContestNavigator
import dagger.Module
import dagger.Provides

@Module
class ContestModule {

    @Provides
    fun provideCoordinator(navigator: ContestNavigator) = ContestCoordinator(navigator)
}
