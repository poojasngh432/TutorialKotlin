package com.example.toolsdemoapp.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.toolsdemoapp.Interface.OnToggledListener;
import com.example.toolsdemoapp.R;
import com.example.toolsdemoapp.model.ToggleableView;
import com.example.toolsdemoapp.util.LabeledSwitch;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Views extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    private AutoCompleteTextView autoCompleteTextView;
    ScrollView scrollView;
    private Button button, snackbarBtnOne, snackbarBtnTwo, snackbarBtnThree;
    private ImageButton imageButton;
    private ImageView imageView;
    private EditText editText;
    private TextView textView;
    private CheckBox checkBox;
    private Spinner spinner;
    private RatingBar ratingBar;
    NumberPicker np;
    SeekBar seekbar;
    String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Orange", "Pear", "Pineapple", "Plum", "Watermelon"};
    String[] country = { "India", "USA", "China", "Japan", "Korea"};

    private Timer timers[];
    private volatile boolean stopped = false;

    private LabeledSwitch labeledSwitch;

    private TimerTask[] timerTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        button = (Button) findViewById(R.id.button);
        imageButton = (ImageButton) findViewById(R.id.image_btn);
        imageView = (ImageView) findViewById(R.id.imageview_btn);
        editText = (EditText) findViewById(R.id.edittext_btn);
        textView = (TextView) findViewById(R.id.textview_btn);
        checkBox = (CheckBox) findViewById(R.id.checkbox_btn);
        spinner = (Spinner) findViewById(R.id.spinner);
        snackbarBtnOne = (Button) findViewById(R.id.snackbar_btn_one);
        snackbarBtnTwo = (Button) findViewById(R.id.snackbar_btn_two);
        snackbarBtnThree = (Button) findViewById(R.id.snackbar_btn_three);
        scrollView = (ScrollView) findViewById(R.id.scroll_view_layout);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        ratingBar = (RatingBar) findViewById(R.id.ratingbar);
        labeledSwitch = (LabeledSwitch) findViewById(R.id.switch4);
        labeledSwitch.setLabelOn("ON");
        labeledSwitch.setLabelOff("OFF");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, fruits);

        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.auto_complete_textview_btn);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(Color.BLUE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Views.this, "You clicked this Button", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Views.this, "This is an ImageButton", Toast.LENGTH_SHORT).show();

            }
        });

        snackbarBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar snackbar = Snackbar
                        .make(scrollView, "This is Default Snackbar", Snackbar.LENGTH_LONG);
                snackbar.show();

            }
        });

        snackbarBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(scrollView, "Message is deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(scrollView, "Message is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();
            }
        });

        snackbarBtnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(scrollView, "Try again!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(scrollView, "You retried!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });
                snackbar.setActionTextColor(Color.RED);
                View sbView = snackbar.getView();
                //   TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
                //   textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        });

        ratingBar.setNumStars(5);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(Views.this,"Rating is: " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();

            }
        });

        labeledSwitch.setOnToggledListener(new OnToggledListener() {
            @Override
            public void onSwitched(ToggleableView toggleableView, boolean isOn) {
                if (labeledSwitch.isOn()) {
                    labeledSwitch.setLabelOn("ON");
                    Toast.makeText(Views.this,"Switch is On", Toast.LENGTH_SHORT).show();

                } else if (!labeledSwitch.isOn()) {
                    labeledSwitch.setLabelOff("OFF");
                    Toast.makeText(Views.this,"Switch is Off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final TextView tv = (TextView) findViewById(R.id.tv);
        np = (NumberPicker) findViewById(R.id.np);

        //Set TextView text color
        tv.setTextColor(Color.parseColor("#418a59"));

        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker
        np.setMinValue(0);
        //Specify the maximum value/number of NumberPicker
        np.setMaxValue(10);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        np.setWrapSelectorWheel(true);

        //Set a value change listener for NumberPicker
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                tv.setText("Selected Number : " + newVal);
                tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                Toast.makeText(Views.this,"seekbar progress: " + progress, Toast.LENGTH_SHORT).show();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Views.this,"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Views.this, "Seek bar progress stopped at:" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        //Creating the ArrayAdapter instance having the fruits list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

        // Showing selected spinner item
        Toast.makeText(Views.this, "Selected: " + country[position], Toast.LENGTH_LONG).show();

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
