package com.navigation.demo.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.navigation.demo.NavigationDemoApp
import com.navigation.demo.R
import com.navigation.demo.di.modules.SplashModule
import kotlinx.android.synthetic.main.fragment_splash.*
import javax.inject.Inject

class SplashFragment : Fragment() {

    @Inject
    lateinit var viewModel: SplashViewModel

    private val navigator: SplashNavigator = SplashNavigatorImpl()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        NavigationDemoApp.appComponent.splashComponent(SplashModule(navigator)).inject(this)

        navigator.fragment = this

        btnStartOnboarding.setOnClickListener {
            viewModel.startClicked()
        }
    }

    override fun onDestroyView() {
        navigator.fragment = null

        super.onDestroyView()
    }
}
