package com.example.tamagochiv1

import Pet
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.tamagochiv1.noti.SaveDataManager
import java.io.FileOutputStream
import java.io.ObjectOutputStream


class CreatePet: AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pet_create)
        var movement :Boolean = false
        var skin = "boxy"
        val nameBox = findViewById<EditText>(R.id.PetNameInputBox)
        val skinSelection = findViewById<SeekBar>(R.id.SkinSelect)
        val bodyPetImage = findViewById<ImageView>(R.id.BodyPetCreate)
        val facePetImage = findViewById<ImageView>(R.id.facePetCreate)
        val saveButton = findViewById<Button>(R.id.SaveButton)
        skinSelection.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(skinSelection: SeekBar?, progress: Int, fromUser: Boolean) {
             if(progress == 0){
                bodyPetImage.setImageResource(R.drawable.petbodytransbackground)
                 facePetImage.setImageResource(R.drawable.petface_happy)
                 facePetImage.layout(10,16,10, 0)
                skin = "boxy"
             }
             else if(progress == 1){
                 bodyPetImage.setImageResource(R.drawable.bunny)
                 facePetImage.setImageResource(R.drawable.bunny_happy)
                 facePetImage.layout(10,1,16, 16)
                 skin = "bunny"
             }

        }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                movement = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                movement = false
            }
        })
        skinSelection.setMax(1)
        saveButton.setOnClickListener{
            val pet = Pet(nameBox.toString(), skin)
            val saveDataMenager = SaveDataManager(this@CreatePet)
            saveDataMenager.putString("name", pet.getName())
            saveDataMenager.putString("skin", pet.getSkin())
            saveDataMenager.putInt("happiness", pet.getHappiness())
            saveDataMenager.putInt("hunger", pet.getHunger())
            saveDataMenager.putInt("energy", pet.getEnergy())
            saveDataMenager.putInt("hygiene", pet.getHygiene())
            saveDataMenager.putInt("hitpoints", pet.getHitpoints())
            saveDataMenager.putBoolean("petAlive", true)
            val goToMainMenu = Intent(this,  MainActivity::class.java)
            startActivity(goToMainMenu)
        }
    }
}