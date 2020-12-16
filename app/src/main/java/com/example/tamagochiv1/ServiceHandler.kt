package com.example.tamagochiv1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServiceHandler : Service() {

    private val TAG = "MyService"



    override fun onBind(intent: Intent?): IBinder? {
      return null
    }


    override fun onCreate() {
        ShowLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ShowLog("onStartCommand")

        for(i in 1..10) {
            ShowLog("Service is running " + i.toString())
            Thread.sleep(1000)
        }



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