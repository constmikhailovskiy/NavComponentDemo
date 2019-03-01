package com.navigation.demo.home.contest

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.jupiter.api.Test

internal class ContestCoordinatorTest {

    private val navigator: ContestNavigator = mock()
    private val coordinator = ContestCoordinator(navigator)

    @Test
    fun start() {
        coordinator.start()

        verify(navigator).openApplicationFormScreen()
        verifyNoMoreInteractions(navigator)
    }

    @Test
    fun applicationSubmitted() {
        coordinator.applicationSubmitted()

        verify(navigator).closeApplicationFormScreen()
        verifyNoMoreInteractions(navigator)
    }
}