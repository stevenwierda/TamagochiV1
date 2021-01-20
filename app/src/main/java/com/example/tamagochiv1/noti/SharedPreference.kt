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

    fun getDifferenceTime(context: Context, key: String) : Long {
        val preference = context.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        var lastTime = preference.getInt(key, 0)
        var currentTime = Date().getTime()

        return currentTime - lastTime

    }



}