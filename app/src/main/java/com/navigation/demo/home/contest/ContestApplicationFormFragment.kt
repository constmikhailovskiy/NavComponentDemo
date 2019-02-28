package com.navigation.demo.home.contest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.navigation.demo.R
import com.navigation.demo.di.SimpleViewModelProviderFactory
import com.navigation.demo.home.HomeActivity
import com.navigation.demo.utils.viewModel
import kotlinx.android.synthetic.main.fragment_contest_application_form.*
import javax.inject.Inject
import javax.inject.Provider

class ContestApplicationFormFragment : Fragment() {

    @Inject
    lateinit var viewModelProvider: Provider<ContestViewModel>

    @Inject
    lateinit var navigator: ContestNavigator

    private val viewModel by lazy {
        requireActivity().viewModel<ContestViewModel>(SimpleViewModelProviderFactory(viewModelProvider))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contest_application_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as HomeActivity).getHomeComponent().contestComponent().inject(this)

        btnSubmit.setOnClickListener {
            viewModel.submitApplication(etParticipantName.text.toString())
        }
    }
}
