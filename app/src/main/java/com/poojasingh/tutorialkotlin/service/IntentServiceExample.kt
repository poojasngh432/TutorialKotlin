package com.poojasingh.tutorialkotlin.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class IntentServiceExample : IntentService("MyIntentService") {
    private val TAG = "IntentServiceExample"

    override fun onHandleIntent(intent: Intent?) {
     //download a large file, playing audio
        Log.d(TAG, "Intent Service started")
    }
}