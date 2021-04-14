package com.poojasingh.tutorialkotlin.service

import android.app.Service
import android.content.Intent
import android.os.AsyncTask
import android.os.IBinder
import android.util.Log
import java.lang.Exception
import java.security.Provider

class ServiceExample : Service() {
    private val TAG = "ServiceExample"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "ServiceExample onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "ServiceExample onStartCommand " + startId)
        var i: Int = 0
        while (i <= 3) {
            try {
                Thread.sleep(1000)
                i++
            } catch (e: Exception) {

            }
            Log.d(TAG,"ServiceExample running")
        }
        return Service.START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "ServiceExample onBind")
        return null
    }

    override fun onDestroy() {
        Log.d(TAG, "ServiceExample onDestroy")
    }

}