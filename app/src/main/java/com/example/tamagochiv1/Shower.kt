package com.example.tamagochiv1

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.util.*


class Shower: AppCompatActivity()  {
    private var xDelta = 0
    private var yDelta = 0
    private var wasProgress = 0
    private var dryProgress = 0
    private val audio_recoder = audioRecorder()
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shower)

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO), 7896)
        }
        audio_recoder.start()

        val mainLayout = findViewById<RelativeLayout>(R.id.main)
        val showerhead = findViewById<ImageView>(R.id.showerhead)
        val progressWassing = findViewById<ProgressBar>(R.id.progressbarWashing)
        val cleanBut = findViewById<ImageButton>(R.id.draybutton)
        progressWassing.progress = wasProgress
        showerhead.setOnTouchListener(onTouchListener())
        cleanBut.setOnClickListener {
            Log.d("audio lvl",audio_recoder.amplitude.toString())
        }

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun onTouchListener(): OnTouchListener? {
        return OnTouchListener { view, event ->
            val x = event.rawX.toInt()
            val y = event.rawY.toInt()
            when (event.action and MotionEvent.ACTION_MASK) {
                MotionEvent.ACTION_DOWN -> {
                    val lParams = view.layoutParams as RelativeLayout.LayoutParams
                    xDelta = x - lParams.leftMargin
                    yDelta = y - lParams.topMargin
                    //Log.d("coords",event.rawY.toString() + ":"+ event.rawX.toString())
                }

                MotionEvent.ACTION_MOVE -> {
                    val layoutParams = view
                            .layoutParams as RelativeLayout.LayoutParams
                    layoutParams.leftMargin = x - xDelta
                    layoutParams.topMargin = y - yDelta
                    layoutParams.rightMargin = 0
                    layoutParams.bottomMargin = 0
                    view.layoutParams = layoutParams


                }
            }
            if (event.rawY.toInt() in 841..1343 && event.rawX.toInt() in 287..814){
                //progressWassing
                if(wasProgress < 101) {
                    wasProgress = wasProgress + 1
                    val progressWassing = findViewById<ProgressBar>(R.id.progressbarWashing)
                    progressWassing.progress = wasProgress
                }
            }
            Log.d("coords", event.rawY.toString() + ":" + event.rawX.toString())
            Log.d("progress", wasProgress.toString())
            //mainLayout.invalidate()
            //Log.d("coords",event.rawY.toString() + ":"+ event.rawX.toString())
            true
        }
    }
}