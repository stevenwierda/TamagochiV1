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

            val saveDataManager = SaveDataManager(context)

            val CHANNEL_ID = "Tamagochi"

            // Get last count
            var count = saveDataManager.getInt("COUNT")
            count += 1;
            // Save current count
            saveDataManager.putInt("COUNT", count)

            // Get difference in time
            var diff = saveDataManager.getDifferenceTime()
            Log.d(TAG, "Diff in time: " + diff)

            // Send notification to the user
            NotificationHelper.sendNotification(context, 300, CHANNEL_ID,"Alarm", "Alarm is gegaan", "ALARM ${count}x AFGEGAAN", false)
            NotificationHelper.sendNotification(context, 302, CHANNEL_ID,"DIFF", "Diff in time", "Diff: ${diff} sec", false)

            Log.d(TAG, "onReceive: " + Date().toString() + "  ,  Count: " + count)
        }
    }

}