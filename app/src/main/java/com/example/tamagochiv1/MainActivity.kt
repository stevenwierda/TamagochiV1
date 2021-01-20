package com.example.tamagochiv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

import android.graphics.PorterDuff;
import android.graphics.Color;

import Pet;
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import com.example.tamagochiv1.noti.NotificationHelper
import com.example.tamagochiv1.noti.AlarmScheduler

class MainActivity : AppCompatActivity() {


    private val CHANNEL_ID =  "Tamagochi"
    private val notificationId = 101


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pet = Pet("Diezel", "jiejkl")
        NotificationHelper.createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false, CHANNEL_ID, "App notification channel")


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

        progress_happiness.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN);
        progress_hunger.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN);
        progress_hygiene.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN);
        progress_energy.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN);
        progress_hitpoints.getProgressDrawable().setColorFilter(Color.parseColor("#64645c"), PorterDuff.Mode.SRC_IN);


        fun update_progress_bars () {
            progress_happiness.setProgress(pet.getHappiness(), true)
            progress_hunger.setProgress(pet.getHunger(), true)
            progress_hygiene.setProgress(pet.getHygiene(), true)
            progress_energy.setProgress(pet.getEnergy(), true)
            progress_hitpoints.setProgress(pet.getHitpoints(), true)
        }

        update_progress_bars();

        goToShowerButton.setOnClickListener{
            pet.addHygiene(100)
            face.setImageResource(R.drawable.petface_sad)
            update_progress_bars()
            NotificationHelper.sendNotification(this, notificationId, CHANNEL_ID,"Hello", "Öbject", "BIG TEXT??", false)
        }

        goToWalkButton.setOnClickListener {
            pet.subHygiene(10)
            pet.subEnergy(20)
            pet.addHappiness((100 - pet.getEnergy()) / 3)
            face.setImageResource(R.drawable.petface_love)
            update_progress_bars()
            AlarmScheduler.createAlarm(this, 60)
        }


        goToFoodButton.setOnClickListener {
            pet.addHunger(25)
            pet.addHappiness((100 - pet.getHunger()) / 3)
            face.setImageResource(R.drawable.petface_hungry)
            update_progress_bars()
        }

        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val jobInfo = JobInfo.Builder(123, ComponentName(this, DeepJobService::class.java))
        val job = jobInfo.setRequiresCharging(false)
//                .setMinimumLatency(1)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build();

        jobScheduler.schedule(job)





    }
}