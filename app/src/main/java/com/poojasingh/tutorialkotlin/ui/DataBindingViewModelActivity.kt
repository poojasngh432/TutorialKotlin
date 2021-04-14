package com.poojasingh.tutorialkotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.data.model.UserProfileModel
import com.poojasingh.tutorialkotlin.data.model.UserProfileViewModel
import com.poojasingh.tutorialkotlin.databinding.ActivityDataBindingViewModelBinding

class DataBindingViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityUserProfileBinding: ActivityDataBindingViewModelBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding_view_model)
        val userProfileModel = UserProfileModel("Emily Lin", ContextCompat.getDrawable(this, R.mipmap.ic_launcher), 26)
        activityUserProfileBinding.setModel(userProfileModel)
        activityUserProfileBinding.setViewModel(UserProfileViewModel(this))

    }
}