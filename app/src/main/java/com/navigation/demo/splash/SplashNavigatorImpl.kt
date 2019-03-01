package com.navigation.demo.splash

import androidx.navigation.Navigation.findNavController
import com.navigation.demo.R

interface SplashNavigator {

    var activity: SplashActivity?

    fun navigateToOnboarding()

    fun navigateToHome()
}

class SplashNavigatorImpl : SplashNavigator {

    override var activity: SplashActivity? = null

    override fun navigateToOnboarding() {
        activity?.let {
            // Show next activity and clear this one from the back stack.
            findNavController(it, R.id.splashNavigationFragment).navigate(R.id.action_start_onboarding)
            it.finish()
        }
    }

    override fun navigateToHome() {
        activity?.let {
            findNavController(it, R.id.splashNavigationFragment).navigate(R.id.action_start_home)
            it.finish()
        }
    }
}
