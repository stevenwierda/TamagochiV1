package com.example.tamagochiv1

import Pet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val saveDataMenager = SaveDataManager(this@MainActivity)
        val petAlive = saveDataMenager.getBoolean("petAlive")
        if (petAlive){
            setContentView(R.layout.activity_main)

            val goToShowerButton = findViewById<ImageButton>(R.id.goToShowerButton)
            val goToWalkButton = findViewById<ImageButton>(R.id.goToWalkButton)
            val goToFoodButton = findViewById<ImageButton>(R.id.goToFoodButton)
            val face = findViewById<ImageView>(R.id.face)
            val body = findViewById<ImageView>(R.id.Body)

            goToShowerButton.setOnClickListener{
                val goToShower = Intent(this, Shower::class.java)
                startActivity(goToShower)
            }

            goToWalkButton.setOnClickListener{
                val goToWalk = Intent(this, Walk::class.java)
                startActivity(goToWalk)
            }

            goToFoodButton.setOnClickListener{
                val goToFeeding = Intent(this, Feeding::class.java)
                startActivity(goToFeeding)
            }
        }
        else{
            val goToCreatePet = Intent(this, CreatePet::class.java)
            startActivity(goToCreatePet)
        }
    }
    fun saveData(pet:Pet){
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
}