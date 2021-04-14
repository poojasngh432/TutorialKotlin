package com.poojasingh.tutorialkotlin.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class MusicService : Service() {
    // declaring object of MediaPlayer
    private lateinit var player: MediaPlayer
    private val TAG = "MusicService"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service onCreate")
    }

    // execution of service will start
    // on calling this method
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service onStartCommand")
        // creating a media player which
        // will play the audio of Default
        // ringtone in android device
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        // providing the boolean
        // value as true to play
        // the audio on loop
        player.setLooping(true)
        // starting the process
        player.start()
        // returns the status
        // of the program
        return START_STICKY
    }

    // execution of the service will
    // stop on calling this method
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Service onDestroy")
        // stopping the process
        player.stop()
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.d(TAG, "Service onBind")
        return null
    }
}