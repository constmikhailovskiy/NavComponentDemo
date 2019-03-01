package com.navigation.demo.di.modules

import com.navigation.demo.home.contest.ContestCoordinator
import com.navigation.demo.home.contest.ContestNavigatorImpl
import dagger.Module
import dagger.Provides

@Module
class ContestModule {

    @Provides
    fun provideCoordinator(navigator: ContestNavigatorImpl) = ContestCoordinator(navigator)
}
