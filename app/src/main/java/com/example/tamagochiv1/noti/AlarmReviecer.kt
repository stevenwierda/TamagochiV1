package com.example.tamagochiv1.noti

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

import com.example.tamagochiv1.noti.SharedPreference;

class AlarmReviecer : BroadcastReceiver() {

    private val TAG = AlarmReviecer::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive: " + Date().toString())

        if (context != null) {
            val CHANNEL_ID = "Tamagochi"

            // Get last count
            var count = SharedPreference.loadData(context, "COUNT")
            count += 1;
            // Save current count
            SharedPreference.saveData(context, "COUNT", count)


            NotificationHelper.sendNotification(context, 300, CHANNEL_ID,"Alarm", "Alarm is gegaan", "ALARM ${count}x AFGEGAAN", false)

            Log.d(TAG, "onReceive: " + Date().toString() + "  ,  Count: " + count)
        }
    }

}