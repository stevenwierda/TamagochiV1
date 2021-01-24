package com.example.tamagochiv1.noti

import android.content.Context
import java.util.*

object SharedPreference {

    fun saveData(context: Context, key : String, value : Int) {

        val preference = context.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun loadData(context: Context, key : String) : Int {

        val preference = context.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        return preference.getInt(key, 0)
    }

    fun saveLastTime(context: Context, time : Long) {

        val preference = context.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val editor = preference.edit()
        editor.putLong("LAST_TIME", time)
        editor.apply()
    }

    fun getDifferenceTime(context: Context) : Long {
        val preference = context.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        var lastTime = preference.getLong("LAST_TIME", 0)
        var currentTime = Date().getTime()/1000
        saveLastTime(context, currentTime)

        return currentTime - lastTime

    }



}