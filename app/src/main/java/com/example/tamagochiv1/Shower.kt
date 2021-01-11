package com.example.tamagochiv1

import android.R
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity


class Shower: AppCompatActivity()  {

    private val xDelta = 0
    private val yDelta = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.tamagochiv1.R.layout.shower)
        val showerhead = findViewById<ImageView>(com.example.tamagochiv1.R.id.showerhead)
        showerhead.setOnTouchListener(onTouchListener());
    }

    private fun onTouchListener(): View.OnTouchListener? {

    }

}