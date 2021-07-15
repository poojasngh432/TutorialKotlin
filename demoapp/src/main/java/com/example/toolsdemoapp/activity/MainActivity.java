package com.example.toolsdemoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.toolsdemoapp.R;

public class MainActivity extends AppCompatActivity {

    private Button dialogBoxesBtn, errorMessagesBtn, viewsBtn, actionBarButton, mediaBtn, animationsBtn, dataListsBtn, loginBtn, touchListenersBtn, freezeLayoutOnTopBtn, scrollingBtn, permissionsBtn, sendEmailBtn, recyclerViewBtn, draggableItemsBtn, bottomNavBtn, bottomNav2, picassoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogBoxesBtn = (Button) findViewById(R.id.dialog_boxes_btn);
        errorMessagesBtn = (Button) findViewById(R.id.error_messages_btn);
        viewsBtn = (Button) findViewById(R.id.views_btn);
        actionBarButton = (Button) findViewById(R.id.action_bar_btn);
        mediaBtn = (Button) findViewById(R.id.media_btn);
        animationsBtn = (Button) findViewById(R.id.animations_btn);
        dataListsBtn = (Button) findViewById(R.id.data_lists_btn);
        loginBtn = (Button) findViewById(R.id.login_btn);
        touchListenersBtn = (Button) findViewById(R.id.touch_listeners_btn);
        freezeLayoutOnTopBtn = (Button) findViewById(R.id.freeze_layout_on_top_btn);
        scrollingBtn = (Button) findViewById(R.id.scrolling_btn);
        permissionsBtn = findViewById(R.id.permissions_btn);
        sendEmailBtn = findViewById(R.id.send_email_btn);
        recyclerViewBtn = findViewById(R.id.recycler_view_btn);
        draggableItemsBtn = findViewById(R.id.draggable_items_btn);
        bottomNavBtn = findViewById(R.id.bottom_nav_btn);
        bottomNav2 = findViewById(R.id.bottom_nav_btn2);
        picassoBtn = findViewById(R.id.picasso_btn);

        dialogBoxesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogBoxes.class);
                startActivity(intent);
            }
        });
        errorMessagesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ErrorMessages.class);
                startActivity(intent);
            }
        });
        viewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Views.class);
                startActivity(intent);
            }
        });
        actionBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActionBarActivity.class);
                startActivity(intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        touchListenersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TouchListenersActivity.class);
                startActivity(intent);
            }
        });
        freezeLayoutOnTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FreezeLayoutOnTopActivity.class);
                startActivity(intent);
            }
        });
        scrollingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });
        permissionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PermissionsActivity.class);
                startActivity(intent);
            }
        });
        sendEmailBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SendEmailActivity.class);
            startActivity(intent);
        });
        recyclerViewBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(intent);
        });
        draggableItemsBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DraggableItemsActivity.class);
            startActivity(intent);
        });
        bottomNavBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BottomNavActivity.class);
            startActivity(intent);
        });
        bottomNav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BottomNavActivity.class);
                startActivity(intent);
            }
        });
        picassoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PicassoActivity.class);
                startActivity(intent);
            }
        });
    }
}
