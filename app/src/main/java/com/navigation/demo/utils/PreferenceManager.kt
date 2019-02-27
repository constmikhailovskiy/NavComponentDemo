package com.navigation.demo.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.navigation.demo.R

class PreferenceManager(private val context: Context) {

    companion object {
        private const val PREFERENCE = "preference"

        private const val KEY_ONBOARDING_SHOWN = "onboarding_shown"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(context.getString(R.string.app_name) + PREFERENCE,
            Context.MODE_PRIVATE)
    }

    fun setOnboardingPassed(passed: Boolean) {
        sharedPreferences.edit { putBoolean(KEY_ONBOARDING_SHOWN, passed) }
    }

    fun isOnboardingPassed() = sharedPreferences.getBoolean(KEY_ONBOARDING_SHOWN, false)
}