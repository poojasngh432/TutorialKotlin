package com.example.toolsdemoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.toolsdemoapp.R;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DialogBoxes extends AppCompatActivity {

    private Button alertBuilderBtn, dialogType1Btn, progressDialogBtn, datePickerBtn, timePickerBtn, positiveBtn, negativeBtn, acceptBtn, retryBtn;
    private Dialog dialogBox = null, posAndNegDialog;
    private ProgressDialog pd = null;
    private final Context context = null;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private ImageView closePosBtnIV, closeNegBtnTV;
    private TextView titleTV, messageTV;
    private EditText selectDateEditText, selectTimeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_boxes);

        alertBuilderBtn = (Button) findViewById(R.id.alert_builder_btn);
        dialogType1Btn = (Button) findViewById(R.id.dialog_type_1_btn);
        progressDialogBtn =(Button) findViewById(R.id.progress_dialog_btn);
        datePickerBtn = (Button) findViewById(R.id.date_picker_btn);
        timePickerBtn = (Button) findViewById(R.id.time_picker_btn);
        selectDateEditText = (EditText) findViewById(R.id.select_date_edit_text);
        selectTimeEditText = (EditText) findViewById(R.id.select_time_edit_text);
        positiveBtn = findViewById(R.id.positive_btn);
        negativeBtn = findViewById(R.id.negative_btn);
        posAndNegDialog = new Dialog(this);
        positiveBtn = findViewById(R.id.positive_btn);
        negativeBtn = findViewById(R.id.negative_btn);

        alertBuilderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogBoxes.this);
                builder.setTitle(R.string.alert);
                builder.setMessage(R.string.alert_message);
                builder.setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox2, int id) {
                                dialogBox2.dismiss();
                            }
                        });
                builder.setPositiveButton(getString(R.string.ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox2, int id) {
                                dialogBox2.dismiss();
                                // finish();   if you wish to leave activity on this click
                            }
                        });
                builder.setCancelable(true);
                builder.show();
            }
        });

        dialogType1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    dialogBox = new Dialog(DialogBoxes.this, android.R.style.Theme_Material_Light_Dialog_Alert);
                } else {
                    dialogBox = new Dialog(DialogBoxes.this);
                }
                dialogBox.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogBox.setContentView(R.layout.dialog_layout);
                if (dialogBox.getWindow() != null) {
                    dialogBox.getWindow().setGravity(Gravity.CENTER);
                }
                dialogBox.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
                dialogBox.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialogBox.setCancelable(true);
                dialogBox.show();
            }
        });

        progressDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd = ProgressDialog.show(DialogBoxes.this, getString(R.string.process_dialog), getString(R.string.process_dialog_message), true, true);
                //    pd.dismiss();
            }
        });

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(DialogBoxes.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                selectDateEditText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        timePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(DialogBoxes.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                selectTimeEditText.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });
        positiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              showPositiveDialog();
            }
        });
        negativeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNegativeDialog();
            }
        });
    }

    private void showNegativeDialog() {
        posAndNegDialog.setContentView(R.layout.negative_dialog);
        closeNegBtnTV = posAndNegDialog.findViewById(R.id.close_neg_dialog_IV);
        retryBtn = posAndNegDialog.findViewById(R.id.btn_retry);
        titleTV = posAndNegDialog.findViewById(R.id.title_pos_TV);
        messageTV = posAndNegDialog.findViewById(R.id.message_pos_TV);

        closeNegBtnTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posAndNegDialog.dismiss();
            }
        });
        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posAndNegDialog.dismiss();
            }
        });

        posAndNegDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        posAndNegDialog.show();
    }

    private void showPositiveDialog() {
        posAndNegDialog.setContentView(R.layout.positive_dialog);
        closePosBtnIV = posAndNegDialog.findViewById(R.id.close_pos_dialog_IV);
        acceptBtn = posAndNegDialog.findViewById(R.id.btn_accept);
        titleTV = posAndNegDialog.findViewById(R.id.title_pos_TV);
        messageTV = posAndNegDialog.findViewById(R.id.message_pos_TV);

        closePosBtnIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posAndNegDialog.dismiss();
            }
        });
        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posAndNegDialog.dismiss();
            }
        });

        posAndNegDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        posAndNegDialog.show();
    }
}
