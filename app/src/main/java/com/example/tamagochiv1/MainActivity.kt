package com.example.tamagochiv1

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

import android.graphics.PorterDuff;
import android.graphics.Color;

import Pet;
import android.os.Build
import android.widget.ProgressBar
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pet = Pet("Diezel", "jiejkl");

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
        }

        goToWalkButton.setOnClickListener {
            pet.subHygiene(10)
            pet.subEnergy(20)
            pet.addHappiness((100 - pet.getEnergy()) / 3)
            face.setImageResource(R.drawable.petface_love)
            update_progress_bars()
        }


        goToFoodButton.setOnClickListener {
            pet.addHunger(25)
            pet.addHappiness((100 - pet.getHunger()) / 3)
            face.setImageResource(R.drawable.petface_hungry)
            update_progress_bars()
        }

        val intent = Intent(this, ServiceHandler::class.java)
        startService(intent)

    }



}