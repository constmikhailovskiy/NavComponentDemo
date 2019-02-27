package com.navigation.demo.splash

class SplashCoordinator(private val navigator: SplashNavigator) {

    fun navigateFromSplash(onboardingPassed: Boolean) {
        when (onboardingPassed) {
            true -> navigator.navigateToHome()
            false -> navigator.navigateToOnboarding()
        }
    }

}