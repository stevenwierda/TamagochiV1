package com.example.tamagochiv1

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.MapView

class Walk : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.walk)
        var map = findViewById<MapView>(R.id.mapView)
    }


}