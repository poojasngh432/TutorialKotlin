package com.example.toolsdemoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.toolsdemoapp.R;

public class SendEmailActivity extends AppCompatActivity {
    // define objects for edit text and button
    Button button;
    EditText sendToET, subjectET, bodyET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        // Getting instance of edittext and button
        sendToET = findViewById(R.id.sendToET);
        subjectET = findViewById(R.id.subjectET);
        bodyET = findViewById(R.id.bodyET);
        button = findViewById(R.id.send_email_btn);

        // attach setOnClickListener to button
        // with Intent object define in it
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                String emailSendTo = sendToET.getText().toString();
                String emailsubject = subjectET.getText().toString();
                String emailbody = bodyET.getText().toString();

                // define Intent object
                // with action attribute as ACTION_SEND
                Intent intent = new Intent(Intent.ACTION_SEND);

                // add three fiels to intent using putExtra function
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { emailSendTo });
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailbody);

                // set type of intent
                intent.setType("message/rfc822");

                // startActivity with intent with chooser
                // as Email client using createChooser function
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });

    }
}
