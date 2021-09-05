package com.raywenderlich.android.imet.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.poojasingh.tutorialkotlin.jetpackcompose.IMetApp
import com.poojasingh.tutorialkotlin.jetpackcompose.data.model.People

class AddPeopleViewModel(application: Application) : AndroidViewModel(application) {

  private val peopleRepository = getApplication<IMetApp>().getPeopleRepository()

  fun addPeople(people: People) {
    peopleRepository.insertPeople(people)
  }

}