package com.example.tamagochiv1.noti

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.tamagochiv1.MainActivity
import com.example.tamagochiv1.R
import com.example.tamagochiv1.notificationId

object NotificationHelper  {

    fun createNotificationChannel(context: Context, importance: Int, showBadge: Boolean, name: String, description: String) {

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channelId = "${context.packageName}-$name"
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)

            // Register the channel with the system
            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun sendNotification(context: Context, id: Int, channelId: String, title: String, message: String, bigText: String, autoCancel: Boolean) {

        val channelId = "${context.packageName}-${channelId}"

        val notificationBuilder = NotificationCompat.Builder(context, channelId).apply {
            setSmallIcon(R.drawable.ic_launcher_foreground)
            setContentTitle(title)
            setContentText(message)
            setAutoCancel(autoCancel)
            setStyle(NotificationCompat.BigTextStyle().bigText(bigText))
            priority = NotificationCompat.PRIORITY_DEFAULT
            setAutoCancel(autoCancel)

            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
            setContentIntent(pendingIntent)
        }

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(id, notificationBuilder.build())
    }

//        // create the pet notification
//        val notificationBuilder = buildNotificationForPet(context, reminderData)
//
//        // add an action to the pet notification
//        val administerPendingIntent = createPendingIntentForAction(context, reminderData)
//        notificationBuilder.addAction(R.drawable.baseline_done_black_24, context.getString(R.string.administer), administerPendingIntent)
//
//        // call notify for both the group and the pet notification
//        val notificationManager = NotificationManagerCompat.from(context)
//        notificationManager.notify(reminderData.type.ordinal, groupBuilder.build())
//        notificationManager.notify(reminderData.id, notificationBuilder.build())
//    }

}