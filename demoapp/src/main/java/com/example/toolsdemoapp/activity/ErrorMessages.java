package com.example.toolsdemoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.toolsdemoapp.R;

public class ErrorMessages extends AppCompatActivity {
    Button toastMessageBtn;
    Button errorAlertBtn;
    private AlertDialog errorAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_messages);
        toastMessageBtn = (Button) findViewById(R.id.toast_message_btn);
        errorAlertBtn = (Button) findViewById(R.id.error_alert_btn);

        toastMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ErrorMessages.this, "This is a Toast message!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        errorAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ErrorMessages.this);
                alertDialogBuilder.setTitle(R.string.alert);

                alertDialogBuilder
                        .setMessage(R.string.error_alert_message)
                        .setCancelable(false)
                        .setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //   startActivity(new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS));
                                dialog.dismiss();
                            }
                        });

                alertDialogBuilder.setCancelable(true);
                errorAlertDialog = alertDialogBuilder.create();
                errorAlertDialog.show();
            }
        });
    }
}
