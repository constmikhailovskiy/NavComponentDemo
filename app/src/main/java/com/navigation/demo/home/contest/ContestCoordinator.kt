package com.navigation.demo.home.contest

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.navigation.demo.R

class ContestCoordinator constructor(private val navigator: ContestNavigator) {

    fun start() {
        Log.d("Coordinator", "Navigator: $navigator")
        navigator.openApplicationFormScreen()
    }

    fun applicationSubmitted() {
        Log.d("Coordinator", "Navigator: $navigator")
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
