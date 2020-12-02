package com.example.tamagochiv1

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

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

        fun update () {
            progress_happiness.setProgress(pet.getHappyness(), true)
            progress_hunger.setProgress(pet.getHunger(), true)
            progress_hygiene.setProgress(pet.getHygiene(), true)
            progress_energy.setProgress(pet.getEnergy(), true)
            progress_hitpoints.setProgress(pet.getHitpoints(), true)
        }

        update();

        goToShowerButton.setOnClickListener{
            pet.setHygiene(100)
            update()
        }

        goToWalkButton.setOnClickListener {
            update()
//            Toast.makeText(applicationContext,pet.getName(),Toast.LENGTH_SHORT).show(}
        }


        goToFoodButton.setOnClickListener {
            pet.setHunger(pet.getHunger() + 25)
            update()
//            Toast.makeText(applicationContext,pet.getSkin(),Toast.LENGTH_SHORT).show()
        }





    }



}