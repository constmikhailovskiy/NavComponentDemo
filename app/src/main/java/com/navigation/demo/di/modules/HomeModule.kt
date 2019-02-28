package com.navigation.demo.di.modules

import androidx.appcompat.app.AppCompatActivity
import com.navigation.demo.di.scopes.ActivityScope
import com.navigation.demo.home.contest.ContestNavigator
import dagger.Module
import dagger.Provides

@Module
class HomeModule(activity: AppCompatActivity) {

    private val contestNavigator by lazy { ContestNavigator(activity) }

    @Provides
    @ActivityScope
    fun provideContestNavigator(): ContestNavigator = contestNavigator
}