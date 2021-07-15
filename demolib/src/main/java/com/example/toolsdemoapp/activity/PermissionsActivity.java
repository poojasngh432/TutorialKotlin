package com.example.toolsdemoapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toolsdemoapp.R;

import java.net.NetworkInterface;

public class PermissionsActivity extends AppCompatActivity {

    // Defining Buttons
    private Button storage, camera, btnDial, btnStatus;
    private EditText etPhNo;
    private TextView tvStatus;

    // Defining Permission codes.
    // We can give any value
    // but unique for each permission.
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        storage = findViewById(R.id.storage);
        camera = findViewById(R.id.camera);
        etPhNo = findViewById(R.id.etPhNo);
        btnDial = findViewById(R.id.btnDial);
        btnStatus = findViewById(R.id.btnStatus);
        tvStatus = findViewById(R.id.tvStatus);

        // Set Buttons on Click Listeners
        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkPermission(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        STORAGE_PERMISSION_CODE);
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkPermission(Manifest.permission.CAMERA,
                        CAMERA_PERMISSION_CODE);
            }
        });

        //Dangerous Permissions
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if we have permission
                int perm = ContextCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.CALL_PHONE);
                if(perm == PackageManager.PERMISSION_GRANTED){
                    callNumber();
                }else{
                    ActivityCompat.requestPermissions(
                            PermissionsActivity.this,
                            new String[]{
                                    Manifest.permission.CALL_PHONE
                            },
                            121
                    );
                }
            }
        });
        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                boolean isConnected = netInfo != null && netInfo.isConnected();
                tvStatus.setText(isConnected ? "CONNECTED":"DISCONNECTED");

            }
        });
    }

    private void callNumber() {
        String telNo = etPhNo.getText().toString();
        Uri uri = Uri.parse("tel:" + telNo);
        Intent i = new Intent(Intent.ACTION_CALL, uri);
        startActivity(i);
    }

    // Function to check and request permission.
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(PermissionsActivity.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(PermissionsActivity.this,
                    new String[] { permission },
                    requestCode);
        }
        else {
            Toast.makeText(PermissionsActivity.this,
                    "Permission already granted",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

    // This function is called when the user accepts or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when the user is prompt for permission.

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(PermissionsActivity.this,
                        "Camera Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(PermissionsActivity.this,
                        "Camera Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
        else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(PermissionsActivity.this,
                        "Storage Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(PermissionsActivity.this,
                        "Storage Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
}
