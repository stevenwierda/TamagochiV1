package com.example.tamagochiv1.noti

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

import com.example.tamagochiv1.noti.SharedPreference


object AlarmScheduler {

    private val TAG = AlarmScheduler::class.java.simpleName

    fun createAlarm (context : Context, second: Int) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // Create a Intent for AlarmManager
        val intent = Intent(context.applicationContext, AlarmReviecer::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        Log.d(TAG, "Create: " + Date().getTime() / 1000)
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (second*1000), AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent)

        // Save lastTime
        SharedPreference.saveLastTime(context, Date().getTime() / 1000)

    }



}