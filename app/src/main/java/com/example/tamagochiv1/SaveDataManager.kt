package com.example.tamagochiv1

import android.content.Context

class SaveDataManager(context: Context) {
    private val saveData = context.getSharedPreferences("saveData", 0)

    fun putBoolean(key: String, value: Boolean){
        saveData.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean{
        return saveData.getBoolean(key, false)
    }

    fun putString(key: String, value: String){
        saveData.edit().putString(key, value).apply()
    }

    fun getString(key: String): String?{
        return saveData.getString(key, null)
    }

    fun putInt(key: String, value: Int){
        saveData.edit().putInt(key, value).apply()
    }

    fun getInt(key: String): Int{
        return saveData.getInt(key,0)
    }

    fun putFloat(key: String, value: Float){
        saveData.edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String): Float{
        return saveData.getFloat(key, 0.0F)
    }

}