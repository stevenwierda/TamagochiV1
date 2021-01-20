package com.example.tamagochiv1.noti

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*


object AlarmScheduler {

    private val TAG = AlarmScheduler::class.java.simpleName

    fun createAlarm (context : Context, second: Int) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(context.applicationContext, AlarmReviecer::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        Log.d(TAG, "Create: " + Date().toString())
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (second*1000), ((second*1000).toLong()), pendingIntent)
    }



}