package com.example.tamagochiv1.noti

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class BootReceiver : BroadcastReceiver() {

    private val TAG = BootReceiver::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent?.action.equals("android.intent.action.BOOT_COMPLETED")) {

            Log.d(TAG, "BOOTCOMPLETE: " + Date().toString())
        }
    }


}