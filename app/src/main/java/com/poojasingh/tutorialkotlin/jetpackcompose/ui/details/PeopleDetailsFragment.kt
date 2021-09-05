package com.poojasingh.tutorialkotlin.jetpackcompose.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.jetpackcompose.data.model.People
import kotlinx.android.synthetic.main.fragment_people_details.*

class PeopleDetailsFragment : Fragment(){
    private lateinit var viewModel: PeopleDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this).get(PeopleDetailsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get people details with provided id
        val peopleId = arguments?.getInt(getString(R.string.people_id))
        peopleId?.let {
            viewModel.getPeopleDetails(peopleId).observe(this, Observer { peopleDetails ->
                populatePeopleDetails(peopleDetails)
            })
        }
    }

    /**
     * Binds people info into views
     */
    private fun populatePeopleDetails(people: People?) {
        textViewName.text = people?.name
        textViewMet.text = people?.metAt
        buttonContact.text = people?.contact
        textViewEmail.text = people?.email
        textViewFacebook.text = people?.facebook
        textViewTwitter.text = people?.twitter
    }
}