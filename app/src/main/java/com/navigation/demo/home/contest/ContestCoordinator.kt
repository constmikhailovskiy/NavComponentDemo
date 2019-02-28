package com.navigation.demo.home.contest

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.navigation.demo.R

class ContestCoordinator constructor(private val navigator: ContestNavigator) {

    fun start() {
        navigator.openApplicationFormScreen()
    }

    fun applicationSubmitted() {
        navigator.closeApplicationFormScreen()
    }
}

class ContestNavigator(private val activity: AppCompatActivity) {

    fun openApplicationFormScreen() {
        activity.findNavController(R.id.mainNavigationFragment)
            .navigate(R.id.action_contestFragment_to_contestApplicationFormFragment)
    }

    fun closeApplicationFormScreen() {
        activity.findNavController(R.id.mainNavigationFragment).navigateUp()
    }
}
