package com.navigation.demo.di.modules

import androidx.appcompat.app.AppCompatActivity
import com.navigation.demo.di.scopes.ActivityScope
import com.navigation.demo.home.contest.ContestNavigatorImpl
import dagger.Module
import dagger.Provides

@Module
class HomeModule(activity: AppCompatActivity) {

    private val contestNavigator by lazy { ContestNavigatorImpl(activity) }

    @Provides
    @ActivityScope
    fun provideContestNavigator(): ContestNavigatorImpl = contestNavigator
}