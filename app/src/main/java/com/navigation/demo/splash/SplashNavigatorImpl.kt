package com.navigation.demo.splash

import androidx.navigation.fragment.findNavController
import com.navigation.demo.R

interface SplashNavigator {

    var fragment: SplashFragment?

    fun navigateToOnboarding()

    fun navigateToHome()
}

class SplashNavigatorImpl : SplashNavigator {

    override var fragment: SplashFragment? = null

    override fun navigateToOnboarding() {
        fragment?.findNavController()?.navigate(R.id.action_start_onboarding)
    }

    override fun navigateToHome() {
        fragment?.findNavController()?.navigate(R.id.action_start_home)
    }
}
