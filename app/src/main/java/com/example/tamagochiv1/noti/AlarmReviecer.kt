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

            // Get difference in time
            var diff = SharedPreference.getDifferenceTime(context)
            Log.d(TAG, "Diff in time: " + diff)

            // Send notification to the user
            NotificationHelper.sendNotification(context, 300, CHANNEL_ID,"Alarm", "Alarm is gegaan", "ALARM ${count}x AFGEGAAN", false)
            NotificationHelper.sendNotification(context, 302, CHANNEL_ID,"DIFF", "Diff in time", "Diff: ${diff}", false)

            Log.d(TAG, "onReceive: " + Date().toString() + "  ,  Count: " + count)
        }
    }

}