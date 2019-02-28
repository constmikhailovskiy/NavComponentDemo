package com.navigation.demo.home.contest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.navigation.demo.R
import com.navigation.demo.di.SimpleViewModelProviderFactory
import com.navigation.demo.home.HomeActivity
import com.navigation.demo.utils.viewModel
import kotlinx.android.synthetic.main.fragment_contest.*
import javax.inject.Inject
import javax.inject.Provider

class ContestFragment : Fragment() {

    @Inject
    lateinit var viewModelProvider: Provider<ContestViewModel>

    @Inject
    lateinit var navigator: ContestNavigator

    private val viewModel by lazy {
        requireActivity().viewModel<ContestViewModel>(SimpleViewModelProviderFactory(viewModelProvider))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as HomeActivity).getHomeComponent().contestComponent().inject(this)

        viewModel.submissionEventsLiveData.observe(this, Observer {
            Log.d("ContestFragment", "Handle submission event: $it")
            handleSubmissionEvent(it)
        })

        btnApply.setOnClickListener { viewModel.startSubmission() }
    }

    private fun handleSubmissionEvent(event: SubmissionEvent) {
        Log.d("Contest fragment", "Event: $event")
        when (event) {
            is SubmissionEvent.ApplicationSubmitted -> {
                btnApply.isVisible = false
                tvStatusLabel.text = "Application was successfully submitted by: ${event.participantName}"
            }
            is SubmissionEvent.ParticipantBanned -> {
                tvStatusLabel.text = "Sorry, this participant is banned"
            }
        }
    }
}
