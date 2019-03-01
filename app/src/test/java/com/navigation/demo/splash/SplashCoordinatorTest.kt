package com.navigation.demo.splash

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.jupiter.api.Test

internal class SplashCoordinatorTest {

    private val navigator: SplashNavigator = mock()
    private val coordinator = SplashCoordinator(navigator)

    @Test
    fun `navigate from splash when onboarding is not passed yet`() {
        coordinator.navigateFromSplash(false)

        verify(navigator).navigateToOnboarding()
        verifyNoMoreInteractions(navigator)
    }

    @Test
    fun `navigate from splash when onboarding is already passed`() {
        coordinator.navigateFromSplash(true)

        verify(navigator).navigateToHome()
        verifyNoMoreInteractions(navigator)
    }
}