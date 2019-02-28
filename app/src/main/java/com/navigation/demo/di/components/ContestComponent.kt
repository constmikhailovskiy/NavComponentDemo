package com.navigation.demo.di.components

import com.navigation.demo.di.modules.ContestModule
import com.navigation.demo.home.contest.ContestApplicationFormFragment
import com.navigation.demo.home.contest.ContestFragment
import dagger.Subcomponent

@Subcomponent(modules = [ContestModule::class])
interface ContestComponent {

    fun inject(fragment: ContestFragment)

    fun inject(fragment: ContestApplicationFormFragment)
}