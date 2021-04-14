package com.poojasingh.tutorialkotlin.data.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.poojasingh.tutorialkotlin.ui.DataBindingViewModelActivity;

public class UserProfileViewModel {

    /* ------------------------------ Constructor */

    private Activity activity;

    /* ------------------------------ Constructor */

    public UserProfileViewModel(@NonNull Activity activity) {
        this.activity = activity;
    }

    /* ------------------------------ Main method */

    /**
     * On profile image clicked
     *
     * @param userName name of user
     */
    public void onProfileImageClicked(@NonNull String userName) {

        Bundle bundle = new Bundle();
        bundle.putString("USERNAME", userName);
        Intent intent = new Intent(activity, DataBindingViewModelActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    /**
     * @param editable         editable
     * @param userProfileModel the model of user profile
     */
    public void userNameTextChange(@NonNull Editable editable,
                                   @NonNull UserProfileModel userProfileModel) {

        userProfileModel.setUserName(editable.toString());
        Log.e("ViewModel", userProfileModel.getUserName());
    }
}