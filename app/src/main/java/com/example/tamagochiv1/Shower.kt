package com.example.tamagochiv1

import android.annotation.SuppressLint
import android.content.Intent
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
    private var xDelta = 1958
    private var yDelta = 719
    private var wasProgress = 0
    private var dryProgress = 0
    private val audio_recoder = audioRecorder()
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shower)

        val mainLayout = findViewById<RelativeLayout>(R.id.main)
        val sponge = findViewById<ImageView>(R.id.showerhead)
        val progressWassing = findViewById<ProgressBar>(R.id.progressbarWashing)
        val progressDrying = findViewById<ProgressBar>(R.id.progressbarDrying)
        val cleanBut = findViewById<ImageView>(R.id.draybutton)
        progressWassing.progress = wasProgress
        progressDrying.progress = dryProgress
        audio_recoder.start()
        sponge.setOnTouchListener(onTouchListener())
        cleanBut.setOnTouchListener(onTouchListener2())

    }

@SuppressLint("ClickableViewAccessibility")
    private fun onTouchListener(): OnTouchListener {
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
                if(wasProgress < 100) {
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

    @SuppressLint("ClickableViewAccessibility")
    private fun onTouchListener2(): OnTouchListener {
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
                    val layoutParams = view.layoutParams as RelativeLayout.LayoutParams
                    layoutParams.leftMargin = x - xDelta
                    layoutParams.topMargin = y - yDelta
                    layoutParams.rightMargin = 0
                    layoutParams.bottomMargin = 0
                    view.layoutParams = layoutParams


                }
            }
            if (event.rawY.toInt() in 841..1343 && event.rawX.toInt() in 287..814 && wasProgress == 100){
                var audioLevel = audio_recoder.amplitude
                Log.d("audio lvl",audioLevel.toString())
                val progressDrying = findViewById<ProgressBar>(R.id.progressbarDrying)
                if (audioLevel > 800){
                    dryProgress = dryProgress + 1
                    progressDrying.progress = dryProgress
                    if (dryProgress == 100){
                        val saveData = getSharedPreferences("saveData", 0)
                        var cleanness = saveData.getFloat("hygiene",0f)
                        cleanness = cleanness + 100
                        saveData.edit().putFloat("hygiene", cleanness).apply()
                        val goToMain = Intent(this, MainActivity::class.java)
                        startActivity(goToMain)
                    }
                }
            }
            true
        }
    }

    private class micLvlCheck()

}
