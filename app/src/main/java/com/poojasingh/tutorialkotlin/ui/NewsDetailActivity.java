package com.poojasingh.tutorialkotlin.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.poojasingh.tutorialkotlin.R;
import com.poojasingh.tutorialkotlin.databinding.ActivityNewsDetailBinding;

public class NewsDetailActivity extends AppCompatActivity {

    private ActivityNewsDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail);
        binding.setUrl(getIntent().getStringExtra("url"));
    }

}
