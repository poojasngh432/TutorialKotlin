package com.poojasingh.tutorialkotlin.jetpackcompose.ui.add

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.jetpackcompose.data.model.People
import com.raywenderlich.android.imet.ui.add.AddPeopleViewModel
import kotlinx.android.synthetic.main.fragment_add_people.*

/**
 * The Fragment to add people
 */
class AddPeopleFragment : Fragment() {

  private lateinit var viewModel: AddPeopleViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
    viewModel = ViewModelProviders.of(this).get(AddPeopleViewModel::class.java)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_add_people, container, false)
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    super.onCreateOptionsMenu(menu, inflater)
    inflater.inflate(R.menu.menu_add_people, menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.menu_add -> {
        savePeopleInfo()
        return true
      }
    }
    return super.onOptionsItemSelected(item)
  }

  /**
   * Saves people info from user input and returns to PeopleListActivity
   */
  private fun savePeopleInfo() {
    val people = People(
        textInputName.editText?.text.toString(),
        textInputMetAt.editText?.text.toString(),
        textInputContact.editText?.text.toString(),
        textInputEmail.editText?.text.toString(),
        textInputFacebook.editText?.text.toString(),
        textInputTwitter.editText?.text.toString()
    )
    viewModel.addPeople(people)

    Navigation.findNavController(view!!).navigateUp()
  }

}
