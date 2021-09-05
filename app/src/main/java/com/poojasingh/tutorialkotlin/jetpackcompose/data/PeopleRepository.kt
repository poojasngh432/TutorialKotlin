package com.poojasingh.tutorialkotlin.jetpackcompose.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.poojasingh.tutorialkotlin.jetpackcompose.data.db.PeopleDao
import com.poojasingh.tutorialkotlin.jetpackcompose.data.db.PeopleDatabase
import com.poojasingh.tutorialkotlin.jetpackcompose.data.model.People

class PeopleRepository(application: Application) {

    private val peopleDao: PeopleDao

    init {
        val peopleDatabase = PeopleDatabase.getInstance(application)
        peopleDao = peopleDatabase.peopleDao()
    }

    fun getAllPeople(): LiveData<List<People>> {
        return peopleDao.getAll()
    }
    fun insertPeople(people: People) {
        peopleDao.insert(people)
    }

    fun findPeople(id: Int): LiveData<People> {
        return peopleDao.find(id)
    }

    fun findPeople(name: String): LiveData<List<People>> {
        return peopleDao.findBy(name)
    }

}