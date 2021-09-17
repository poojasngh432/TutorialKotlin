package com.poojasingh.tutorialkotlin.jetpackcompose.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.databinding.FragmentPeopleDetailsBinding
import com.poojasingh.tutorialkotlin.jetpackcompose.data.model.People

class PeopleDetailsFragment : Fragment() {
    private lateinit var viewModel: PeopleDetailsViewModel
    private lateinit var binding: FragmentPeopleDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PeopleDetailsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPeopleDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get people details with provided id
        val peopleId = arguments?.getInt(getString(R.string.people_id))
        peopleId?.let {
            viewModel.getPeopleDetails(peopleId)
                .observe(viewLifecycleOwner, Observer { peopleDetails ->
                    populatePeopleDetails(peopleDetails)
                })
        }
    }

    /**
     * Binds people info into views
     */
    private fun populatePeopleDetails(people: People?) {
        binding.textViewName.text = people?.name
        binding.textViewMet.text = people?.metAt
        binding.buttonContact.text = people?.contact
        binding.textViewEmail.text = people?.email
        binding.textViewFacebook.text = people?.facebook
        binding.textViewTwitter.text = people?.twitter
    }
}