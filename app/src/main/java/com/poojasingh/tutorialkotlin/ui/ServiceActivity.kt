package com.poojasingh.tutorialkotlin.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.service.*

class ServiceActivity : AppCompatActivity() {
    var flag = true
    var flagAS = true
    var flagIS = true
    var flagFS = true
    //Once initiated, the service can run continuously in the background even if the component is destroyed which was responsible for the start of the service.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
    }

    fun onButtonClick(view: View) {
        if(view.id == R.id.start_service_btn) {
            val intent = Intent(this, ServiceExample::class.java)
            if(flag){
                findViewById<Button>(R.id.start_service_btn).text = "Stop Service"
                flag = false
                startService(intent)
            } else {
                findViewById<Button>(R.id.start_service_btn).text = "Start Service"
                flag = true
                stopService(intent)
            }
        } else if(view.id == R.id.start_serviceasync_btn) {
            val intent = Intent(this, ServiceAsyncExample::class.java)
            if(flagAS){
                findViewById<Button>(R.id.start_serviceasync_btn).text = "Stop IntentService"
                flagAS = false
                startService(intent)
            } else {
                findViewById<Button>(R.id.start_serviceasync_btn).text = "Start IntentService"
                flagAS = true
                stopService(intent)
            }
        } else if(view.id == R.id.start_music_service_btn) {
            val intent = Intent(this, MusicService::class.java)
            startService(intent)
        } else if(view.id == R.id.stop_music_service_btn) {
            val intent = Intent(this, MusicService::class.java)
            stopService(intent)
        } else if(view.id == R.id.foreground_service_btn) {
            val intent = Intent(this, ForegroundService::class.java)
            if(flagFS){
                findViewById<Button>(R.id.foreground_service_btn).text = "Stop ForegroundService"
                flagFS = false
//                startService(intent)
                ForegroundService.startService(this, "Foreground Service is running...")
            } else {
                findViewById<Button>(R.id.foreground_service_btn).text = "Start ForegroundService"
                flagFS = true
//                stopService(intent)
                ForegroundService.stopService(this)
            }
        } else if(view.id == R.id.intent_service_btn) {
            val intent = Intent(this, IntentServiceExample::class.java)
            if(flagIS){
                findViewById<Button>(R.id.intent_service_btn).text = "Stop IntentService"
                flagIS = false
                startService(intent)
            } else {
                findViewById<Button>(R.id.intent_service_btn).text = "Start IntentService"
                flagIS = true
                stopService(intent)
            }
        }
    }

}