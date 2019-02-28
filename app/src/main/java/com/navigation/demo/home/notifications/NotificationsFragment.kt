package com.navigation.demo.home.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.navigation.demo.R
import com.navigation.demo.home.NotificationsService
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnShowEventsNotif.setOnClickListener {
            launchNotificationService(NotificationsService.ACTION_SHOW_EVENTS_NOTIF)
        }

        btnShowPrivacyPolicyNotif.setOnClickListener {
            launchNotificationService(NotificationsService.ACTION_SHOW_PRIVACY_NOTIF)
        }

        btnShowContestNotif.setOnClickListener {
            launchNotificationService(NotificationsService.ACTION_SHOW_CONTEST_NOTIF)
        }
    }

    private fun launchNotificationService(action: String) {
        requireActivity().startService(NotificationsService.createIntent(requireContext(), action))
    }
}
