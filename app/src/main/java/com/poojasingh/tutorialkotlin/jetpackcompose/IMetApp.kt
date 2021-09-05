package com.poojasingh.tutorialkotlin.jetpackcompose

import android.app.Application
import com.poojasingh.tutorialkotlin.jetpackcompose.data.PeopleRepository

class IMetApp : Application() {

    /**
     * Provides centralised Repository throughout the app
     */
    fun getPeopleRepository() = PeopleRepository(this)

}