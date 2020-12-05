package com.example.tamagochiv1

import Pet
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity


class CreatePet: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pet_create)
        val nameBox = findViewById<EditText>(R.id.PetNameInputBox)
        val skinSelection = findViewById<SeekBar>(R.id.SkinSelect)
        var skinNumber = skinSelection.setOnSeekBarChangeListener()
        skinSelection.setMax()

        val pet = Pet(nameBox, )
    }
}