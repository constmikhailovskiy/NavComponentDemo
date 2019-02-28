package com.navigation.demo.home.contest

sealed class SubmissionEvent {

    data class ApplicationSubmitted(val participantName: String) : SubmissionEvent()

    data class ParticipantBanned(val participantName: String) : SubmissionEvent()
}
