package com.navigation.demo.home

import android.app.IntentService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.IdRes
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.navigation.demo.R


class NotificationsService : IntentService(TAG) {

    companion object {
        const val ACTION_SHOW_PRIVACY_NOTIF = "action_show_privacy_notif"
        const val ACTION_SHOW_CONTEST_NOTIF = "action_show_contest_notif"
        const val ACTION_SHOW_EVENTS_NOTIF = "action_show_events_notif"

        fun createIntent(context: Context, action: String): Intent {
            return Intent(context, NotificationsService::class.java).apply {
                putExtra(EXTRA_ACTION, action)
            }
        }

        private const val TAG = "notifications_service"

        private const val EXTRA_ACTION = "action"

        private const val CHANNEL_ID = "navigation_demo"

        private const val NOTIFICATION_ID = 42
    }

    override fun onHandleIntent(intent: Intent?) {
        val action = intent?.extras?.getString(EXTRA_ACTION)
        when (action) {
            ACTION_SHOW_PRIVACY_NOTIF -> {
                showNotification(R.id.fragmentPrivacyPolicy, "Important privacy policy update")
            }
            ACTION_SHOW_EVENTS_NOTIF -> {
                showNotification(R.id.fragmentEventsList, "Hey! See the events happening soon in your town!")
            }
            ACTION_SHOW_CONTEST_NOTIF -> {
                showNotification(R.id.fragmentContestApplication, "Apply for a contest NOW!")
            }
        }
    }

    private fun showNotification(@IdRes destinationId: Int, title: String) {
        val pendingIntent = NavDeepLinkBuilder(this)
            .setComponentName(HomeActivity::class.java)
            .setGraph(R.navigation.home_graph)
            .setDestination(destinationId)
            .createPendingIntent()

        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setContentTitle(title)
            .setChannelId(CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notifications_black_24dp)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val notifManager = NotificationManagerCompat.from(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notifManager.createNotificationChannel(channel)
        }

        notifManager.notify(NOTIFICATION_ID, notification)
    }
}