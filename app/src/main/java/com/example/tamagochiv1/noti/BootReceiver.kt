package com.example.tamagochiv1.noti

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class BootReceiver : BroadcastReceiver() {

    private val TAG = BootReceiver::class.java.simpleName

    // When the telephone restart this code will run
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent?.action.equals("android.intent.action.BOOT_COMPLETED")) {

            // Start a new Alarm
            AlarmScheduler.createAlarm(context, 1)
            Log.d(TAG, "BOOTCOMPLETE: " + Date().toString())
        }
    }


}