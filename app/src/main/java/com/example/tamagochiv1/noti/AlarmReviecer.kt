package com.example.tamagochiv1.noti

import Pet
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.*

class AlarmReviecer : BroadcastReceiver() {

    private val TAG = AlarmReviecer::class.java.simpleName

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive: " + Date().toString())

        if (context != null) {

            val saveDataManager = SaveDataManager(context)
            val pet = loadData(context)

            val CHANNEL_ID = "Tamagochi"

            // Get last count
            var count = saveDataManager.getInt("COUNT")
            count += 1;
            // Save current count
            saveDataManager.putInt("COUNT", count)

            // Get difference in time
            var diff = saveDataManager.getDifferenceTime()
            Log.d(TAG, "Diff in time: " + diff)

            pet.subHappiness(0, diff)
            pet.subHunger(0, diff)
            pet.subEnergy(0, diff)
            pet.subHygiene(0, diff)

            // Send notification to the user
//            NotificationHelper.sendNotification(context, 300, CHANNEL_ID,"Alarm", "Alarm is gegaan", "ALARM ${count}x AFGEGAAN", false)
//            NotificationHelper.sendNotification(context, 302, CHANNEL_ID,"DIFF", "Diff in time", "Diff: ${diff} sec", false)

            Log.d(TAG, "onReceive: " + Date().toString() + "  ,  Count: " + count)

            saveData(context, pet)
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun saveData(context: Context,pet: Pet) {
        val saveDataMenager = SaveDataManager(context)
        saveDataMenager.putString("name", pet.getName())
        saveDataMenager.putString("skin", pet.getSkin())
        saveDataMenager.putInt("happiness", pet.getHappiness())
        saveDataMenager.putInt("hunger", pet.getHunger())
        saveDataMenager.putInt("energy", pet.getEnergy())
        saveDataMenager.putInt("hygiene", pet.getHygiene())
        saveDataMenager.putInt("hitpoints", pet.getHitpoints())
        saveDataMenager.putBoolean("petAlive", true)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadData(context: Context): Pet {
        val pet = Pet("bob","test")
        val saveDataMenager = SaveDataManager(context)
        pet.setName(saveDataMenager.getString("name").toString())
        pet.setSkin(saveDataMenager.getString("skin").toString())
        pet.setHappyness(saveDataMenager.getInt("happyness"))
        pet.setHunger(saveDataMenager.getInt("hunger"))
        pet.setEnergy(saveDataMenager.getInt("energy"))
        pet.setHygiene(saveDataMenager.getInt("hygiene"))
        saveDataMenager.putInt("hitpoints", pet.getHitpoints())
        pet.setHitpoints(saveDataMenager.getInt("hitpoints"))
        return pet
    }

}