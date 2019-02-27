package com.navigation.demo.splash

import androidx.lifecycle.ViewModel
import com.navigation.demo.utils.PreferenceManager
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val coordinator: SplashCoordinator,
    private val preferences: PreferenceManager
) : ViewModel() {

    fun startClicked() {
        val onboardingPassed = preferences.isOnboardingPassed()
        if (!onboardingPassed) {
            preferences.setOnboardingPassed(true)
        }
        coordinator.navigateFromSplash(onboardingPassed)
    }
}