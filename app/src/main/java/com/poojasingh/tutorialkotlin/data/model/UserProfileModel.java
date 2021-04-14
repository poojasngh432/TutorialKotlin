package com.poojasingh.tutorialkotlin.data.model;

import android.graphics.drawable.Drawable;

public class UserProfileModel {
    private String userName = "";
    private final Drawable imageProfileRId;
    private final int age;

    /*----------------------- Constructor */

    public UserProfileModel(String userName, Drawable imageProfileRId, int age) {
        this.userName = userName;
        this.imageProfileRId = imageProfileRId;
        this.age = age;
    }

    /*----------------------- Getter */

    public String getUserName() {
        return userName;
    }
    public Drawable getImageProfileRId() {
        return imageProfileRId;
    }

    public int getAge() {
        return age;
    }

    public void setUserName(String toString) {
    }
}
