package com.poojasingh.tutorialkotlin.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.lifecycle.SomeObserver
import com.poojasingh.tutorialkotlin.ui.fragments.ArticleListFragment

class NewsActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // Add project list fragment if this is first creation

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            val fragment = ArticleListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, ArticleListFragment.TAG).commit()
        }

        // for shake of
        lifecycle.addObserver(SomeObserver())
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }
}