package com.navigation.demo.di.components

import com.navigation.demo.di.modules.OnboardingModule
import com.navigation.demo.di.scopes.ActivityScope
import com.navigation.demo.onboarding.FirstOnboardingFragment
import com.navigation.demo.onboarding.SecondOnboardingFragment
import com.navigation.demo.onboarding.ThirdOnboardingFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [OnboardingModule::class])
interface OnboardingComponent {

    fun inject(fragment: FirstOnboardingFragment)

    fun inject(fragment: SecondOnboardingFragment)

    fun inject(fragment: ThirdOnboardingFragment)
}