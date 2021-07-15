package com.example.toolsdemoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.amar.library.ui.StickyScrollView;

import com.example.toolsdemoapp.R;

public class FreezeLayoutOnTopActivity extends AppCompatActivity {

    private LinearLayout filterLayout_ll;
    private StickyScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freeze_layout_on_top);
        scrollView = (StickyScrollView) findViewById(R.id.scroll_view);
        filterLayout_ll = findViewById(R.id.filterLayout);

    }
}
