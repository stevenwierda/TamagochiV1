package com.example.tamagochiv1

import Pet
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import com.example.tamagochiv1.noti.AlarmScheduler
import com.example.tamagochiv1.noti.NotificationHelper
import com.example.tamagochiv1.noti.SaveDataManager

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID =  "Tamagochi"
    private val notificationId = 101

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val saveDataMenager = SaveDataManager(this@MainActivity)
        val petAlive = saveDataMenager.getBoolean("petAlive")
        if (petAlive) {
            setContentView(R.layout.activity_main)

            val pet = loadData()
            //val pet = Pet("Diezel", "jiejkl")
            NotificationHelper.createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false, CHANNEL_ID, "App notification channel")
            AlarmScheduler.createAlarm(this, 1)

            val goToShowerButton = findViewById<ImageButton>(R.id.goToShowerButton)
            val goToWalkButton = findViewById<ImageButton>(R.id.goToWalkButton)
            val goToFoodButton = findViewById<ImageButton>(R.id.goToFoodButton)
            val face = findViewById<ImageView>(R.id.face)
            val body = findViewById<ImageView>(R.id.Body)

            val progress_happiness = findViewById<ProgressBar>(R.id.progress_happiness)
            val progress_hunger = findViewById<ProgressBar>(R.id.progress_hunger)
            val progress_hygiene = findViewById<ProgressBar>(R.id.progress_hygiene)
            val progress_energy = findViewById<ProgressBar>(R.id.progress_energy)
            val progress_hitpoints = findViewById<ProgressBar>(R.id.progress_hitpoints)

            progress_happiness.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN)
            progress_hunger.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN)
            progress_hygiene.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN)
            progress_energy.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN)
            progress_hitpoints.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN)

            fun update_progress_bars () {
                progress_happiness.setProgress(pet.getHappiness().toInt(), true)
                progress_hunger.setProgress(pet.getHunger().toInt(), true)
                progress_hygiene.setProgress(pet.getHygiene().toInt(), true)
                progress_energy.setProgress(pet.getEnergy().toInt(), true)
                progress_hitpoints.setProgress(pet.getHitpoints(), true)
            }

            update_progress_bars();

            goToShowerButton.setOnClickListener {

                if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO), 7896)
                } else {
                    val goToShower = Intent(this, Shower::class.java)
                    startActivity(goToShower)
                }
            }

            goToWalkButton.setOnClickListener {
                pet.subHygiene(10f)
                pet.subEnergy(20f)
                pet.addHappiness((100 - pet.getEnergy()) / 3)
                face.setImageResource(R.drawable.petface_love)
                update_progress_bars()
                saveData(pet)
            }

            goToFoodButton.setOnClickListener {
                pet.addHunger(25f)
                pet.addHappiness((100 - pet.getHunger()) / 3)
                face.setImageResource(R.drawable.petface_hungry)
                saveData(pet)
                update_progress_bars()
                //val goToFeeding = Intent(this, Feeding::class.java)
                //startActivity(goToFeeding)
                saveData(pet)
            }
        } else {
            val goToCreatePet = Intent(this, CreatePet::class.java)
            startActivity(goToCreatePet)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun saveData(pet: Pet) {
        val saveDataMenager = SaveDataManager(this@MainActivity)
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
    fun loadData(): Pet {
        val pet = Pet("bob","test")
        val saveDataMenager = SaveDataManager(this@MainActivity)
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