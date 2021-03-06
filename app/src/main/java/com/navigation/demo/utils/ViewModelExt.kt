package com.navigation.demo.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> FragmentActivity.viewModel(factory: ViewModelProvider.Factory)
        = ViewModelProviders.of(this, factory)[T::class.java]

inline fun <reified T : ViewModel> Fragment.viewModel(factory: ViewModelProvider.Factory)
        = ViewModelProviders.of(this, factory)[T::class.java]