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

            pet.subHappiness(0f, diff)
            pet.subHunger(0f, diff)
            pet.subEnergy(0f, diff)
            pet.subHygiene(0f, diff)

            // Send notification to the user
//            NotificationHelper.sendNotification(context, 300, CHANNEL_ID,"Alarm", "Alarm is gegaan", "ALARM ${count}x AFGEGAAN", false)
//            NotificationHelper.sendNotification(context, 302, CHANNEL_ID,"DIFF", "Diff in time", "Diff: ${diff} sec", false)

            if (pet.getHappiness() < 10) {
                NotificationHelper.sendNotification(context, 200, CHANNEL_ID, "Low happiness", "${pet.getName()} is not happy anymore gif him some attention", "Happiness is low!!", false)
            }

            if (pet.getHunger() < 10) {
                NotificationHelper.sendNotification(context, 201, CHANNEL_ID, "Low Hunger", "${pet.getName()} is very hunger give him/her some food", "Hunger is low!!", false)
            }

            if (pet.getEnergy() < 10) {
                NotificationHelper.sendNotification(context, 202, CHANNEL_ID, "Low Energy", "${pet.getName()} is very tired give him some sleep", "Energy is low!!", false)
            }

            if (pet.getHygiene() < 10) {
                NotificationHelper.sendNotification(context, 203, CHANNEL_ID, "Low Hygiene", "${pet.getName()} needs to go to the shower because he/she is dirty", "Hygiene is low!!", false)
            }


            Log.d(TAG, "onReceive: " + Date().toString() + "  ,  Count: " + count)

            saveData(context, pet)
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun saveData(context: Context,pet: Pet) {
        val saveDataMenager = SaveDataManager(context)
        saveDataMenager.putString("name", pet.getName())
        saveDataMenager.putString("skin", pet.getSkin())
        saveDataMenager.putFloat("happiness", pet.getHappiness())
        saveDataMenager.putFloat("hunger", pet.getHunger())
        saveDataMenager.putFloat("energy", pet.getEnergy())
        saveDataMenager.putFloat("hygiene", pet.getHygiene())
        saveDataMenager.putInt("hitpoints", pet.getHitpoints())
        saveDataMenager.putBoolean("petAlive", true)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadData(context: Context): Pet {
        val pet = Pet("bob","test")
        val saveDataMenager = SaveDataManager(context)
        pet.setName(saveDataMenager.getString("name").toString())
        pet.setSkin(saveDataMenager.getString("skin").toString())
        pet.setHappyness(saveDataMenager.getFloat("happyness"))
        pet.setHunger(saveDataMenager.getFloat("hunger"))
        pet.setEnergy(saveDataMenager.getFloat("energy"))
        pet.setHygiene(saveDataMenager.getFloat("hygiene"))
        saveDataMenager.putInt("hitpoints", pet.getHitpoints())
        pet.setHitpoints(saveDataMenager.getInt("hitpoints"))
        return pet
    }

}