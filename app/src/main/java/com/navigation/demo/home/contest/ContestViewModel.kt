package com.navigation.demo.home.contest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ContestViewModel @Inject constructor(
    private val coordinator: ContestCoordinator
) : ViewModel() {

    private val submissionEventsMutableLiveData: MutableLiveData<SubmissionEvent> = MutableLiveData()

    val submissionEventsLiveData: LiveData<SubmissionEvent>
        get() = submissionEventsMutableLiveData

    fun startSubmission() {
        coordinator.start()
    }

    fun submitApplication(participantName: String) {
        coordinator.applicationSubmitted()
        submissionEventsMutableLiveData.value = when (participantName) {
            "Jake Wharton" -> SubmissionEvent.ParticipantBanned(participantName)
            else -> SubmissionEvent.ApplicationSubmitted(participantName)
        }
    }
}
