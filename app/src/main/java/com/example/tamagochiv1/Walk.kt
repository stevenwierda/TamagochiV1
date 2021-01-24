package com.example.tamagochiv1

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*

class Walk : AppCompatActivity() {
    // uniek id
    var PERMISSION_ID = 1000

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest: LocationRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.walk)

        //fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        //var lastLocation: Location? = null
        //requestPermission()
        //NewLocationData()

    }

//    private fun checkPermission(): Boolean {
//        if (
//                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
//                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
//        ) {
//            return true
//        }
//
//        return false
//    }
//
//        private fun requestPermission() {
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ), PERMISSION_ID
//        )
//    }
//
//    private fun isLocationEnabled(): Boolean {
//        var locationManager: LocationManager =
//            getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
//            LocationManager.NETWORK_PROVIDER
//        )
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == PERMISSION_ID) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Log.d("Debug", "You have premission")
//            }
//        }
//    }
//
//    private fun getLocation() {
//        if (checkPermission()) {
//            if (isLocationEnabled()) {
//                fusedLocationProviderClient.lastLocation.addOnCompleteListener() { task ->
//                    var location: Location? = task.result
//
//                    if (location == null) {
//                        NewLocationData()
//                    } else {
//                        Log.d("Debug:" ,"Your Location:"+ location.longitude)
//                    }
//                }
//            } else {
//                Toast.makeText(this, "Please enable your location service", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        } else {
//            requestPermission()
//        }
//    }
//
//
//    fun NewLocationData() {
//        var locationRequest = LocationRequest()
//        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        locationRequest.interval = 0
//        locationRequest.fastestInterval = 0
//        locationRequest.numUpdates = 1
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            requestPermission()
//            return
//        }
//        fusedLocationProviderClient!!.requestLocationUpdates(
//            locationRequest, locationCallback, Looper.myLooper()
//        )
//    }
//
//    fun LocationUpdater() {
//        var locationRequest = LocationRequest()
//        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        locationRequest.interval = 0
//        locationRequest.fastestInterval = 0
//        locationRequest.numUpdates = 1
//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
//        if (checkPermission()) {
//            fusedLocationProviderClient.requestLocationUpdates(
//                    locationRequest, locationCallback, Looper.myLooper()
//            )
//        }
//        else{
//            requestPermission()
//        }
//    }
//
//
//    private val locationCallback = object : LocationCallback() {
//        override fun onLocationResult(locationResult: LocationResult) {
//            var lastLocation: Location = locationResult.lastLocation
//            Log.d("Debug:", "your last last location: " + lastLocation.longitude.toString())
//        }
//    }
}