package com.navigation.demo.di.modules

import android.content.Context
import com.navigation.demo.utils.PreferenceManager
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val appContext: Context) {

    @Provides
    fun providePreferencesManager(): PreferenceManager = PreferenceManager(appContext)
}