package com.example.tamagochiv1

import Pet
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity


class CreatePet: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pet_create)
        var movement :Boolean = false
        var skin = "boxy"
        val nameBox = findViewById<EditText>(R.id.PetNameInputBox)
        val skinSelection = findViewById<SeekBar>(R.id.SkinSelect)
        val bodyPetImage = findViewById<ImageView>(R.id.BodyPetCreate)
        skinSelection.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(skinSelection: SeekBar?, progress: Int, fromUser: Boolean) {
             if(progress == 1){
                bodyPetImage.setImageResource(R.drawable.petbodytransbackground)
                skin = "boxy"
             }
             else if(progress == 2){
                 bodyPetImage.setImageResource(R.drawable.bunny)
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
        val pet = Pet(nameBox.toString(), skin)
    }
}