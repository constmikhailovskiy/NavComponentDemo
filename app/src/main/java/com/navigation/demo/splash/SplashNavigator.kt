package com.navigation.demo.splash

import androidx.navigation.Navigation.findNavController
import com.navigation.demo.R

class SplashNavigator {

    var activity: SplashActivity? = null

    fun navigateToOnboarding() {
        activity?.let {
            // Show next activity and clear this one from the back stack.
            findNavController(it, R.id.splashNavigationFragment).navigate(R.id.action_start_onboarding)
            it.finish()
        }
    }

    fun navigateToHome() {
        activity?.let {
            findNavController(it, R.id.splashNavigationFragment).navigate(R.id.action_start_home)
            it.finish()
        }
    }
}
