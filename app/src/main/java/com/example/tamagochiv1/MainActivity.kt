package com.example.tamagochiv1

import Pet
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val saveDataMenager = SaveDataManager(this@MainActivity)
        val petAlive = saveDataMenager.getBoolean("petAlive")
        if (petAlive) {
            setContentView(R.layout.activity_main)

            val pet = loadData()
            //val pet = Pet("Diezel", "jiejkl")

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

            progress_happiness.progress = pet.getHappyness()
            progress_hunger.progress = pet.getHunger()
            progress_hygiene.progress = pet.getHygiene()
            progress_energy.progress = pet.getEnergy()
            progress_hitpoints.progress = pet.getHitpoints()

            goToShowerButton.setOnClickListener {
                val goToShower = Intent(this, Shower::class.java)
                startActivity(goToShower)
            }

            goToWalkButton.setOnClickListener {
                val goToWalk = Intent(this, Walk::class.java)
                startActivity(goToWalk)
            }

            goToFoodButton.setOnClickListener {
                val goToFeeding = Intent(this, Feeding::class.java)
                startActivity(goToFeeding)
            }
        } else {
            val goToCreatePet = Intent(this, CreatePet::class.java)
            startActivity(goToCreatePet)
        }
    }

    fun saveData(pet: Pet) {
        val saveDataMenager = SaveDataManager(this@MainActivity)
        saveDataMenager.putString("name", pet.getName())
        saveDataMenager.putString("skin", pet.getSkin())
        saveDataMenager.putInt("happiness", pet.getHappyness())
        saveDataMenager.putInt("hunger", pet.getHunger())
        saveDataMenager.putInt("energy", pet.getEnergy())
        saveDataMenager.putInt("hygiene", pet.getHygiene())
        saveDataMenager.putInt("hitpoints", pet.getHitpoints())
        saveDataMenager.putBoolean("petAlive", true)
    }

    fun loadData(): Pet {
        val pet = Pet("bob","test")
        val saveDataMenager = SaveDataManager(this@MainActivity)
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