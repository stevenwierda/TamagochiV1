package com.example.tamagochiv1.noti

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class AlarmReviecer : BroadcastReceiver() {

    private val TAG = AlarmReviecer::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive: " + Date().toString())

        if (context != null) {
            val CHANNEL_ID = "Tamagochi"
            NotificationHelper.sendNotification(context, 300, CHANNEL_ID,"Alarm", "Alarm is gegaan", "ALARM IS AFGEGAAN", false)
        }


    }

}