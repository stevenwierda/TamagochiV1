package com.example.tamagochiv1

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.SystemClock
import android.provider.Settings
import android.util.Log

class ServiceHandler : Service() {

    private val TAG = "MyService"
    private var i = 0


    override fun onBind(intent: Intent?): IBinder? {
      return null
    }


    override fun onCreate() {
        ShowLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ShowLog("onStartCommand")

        val mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {
                Log.d(TAG, i.toString())
                mainHandler.postDelayed(this, 1000)
                i++
            }
        })



        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        ShowLog("onDestroy")
        super.onDestroy()
    }


    fun ShowLog(message : String) {
        Log.d(TAG, message)
    }
}