package com.example.toolsdemoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.toolsdemoapp.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private Button swipeToActionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        swipeToActionBtn = findViewById(R.id.swipe_to_action_btn);

        swipeToActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this, SwipeToActionActivity.class);
                startActivity(intent);
            }
        });
    }
}
