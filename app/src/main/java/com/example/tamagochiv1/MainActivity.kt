package com.example.tamagochiv1

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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


    }
}