package com.poojasingh.tutorialkotlin.jetpackcompose.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.poojasingh.tutorialkotlin.jetpackcompose.IMetApp
import com.poojasingh.tutorialkotlin.jetpackcompose.data.model.People

class PeoplesListViewModel(application: Application) : AndroidViewModel(application) {

    private val peopleRepository = getApplication<IMetApp>().getPeopleRepository()
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllPeople()
    }

    // 1
    fun getPeopleList(): LiveData<List<People>> {
        return peopleList
    }

    // 2
    fun getAllPeople() {
        peopleList.addSource(peopleRepository.getAllPeople()) { peoples ->
            peopleList.postValue(peoples)
        }
    }

    // 1
    fun searchPeople(name: String) {
        // 2
        peopleList.addSource(peopleRepository.findPeople(name)) { peoples ->
            // 3
            peopleList.postValue(peoples)
        }
    }

}