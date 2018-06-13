package edu.upf.pillup.CONTROLLERS;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.DateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.text.SimpleDateFormat;

import edu.upf.pillup.HOME_ICONS.Calendar;
import edu.upf.pillup.HOME_ICONS.Buy;
import edu.upf.pillup.HOME_ICONS.Profile;
import edu.upf.pillup.HOME_ICONS.Pills;
import edu.upf.pillup.R;

public class Home extends AppCompatActivity {

    ImageButton androidImageButton1;
    ImageButton androidImageButton2;
    ImageButton androidImageButton3;
    ImageButton androidImageButton4;
    SimpleDateFormat simpleDateFormat;
    java.util.Calendar calendar;
    String date;
    TextView textView;
    TextView textViewDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //ICONS
        androidImageButton1 = (ImageButton) findViewById(R.id.calendar);
        androidImageButton2 = (ImageButton) findViewById(R.id.pill);
        androidImageButton3 = (ImageButton) findViewById(R.id.compra);
        androidImageButton4 = (ImageButton) findViewById(R.id.perfil);

        //DATE
        calendar = java.util.Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        textViewDate = (TextView) findViewById(R.id.date);
        textViewDate.setText(currentDate.toUpperCase());
        textViewDate.setTextColor(Color.parseColor("#E1A18E"));

        //CLICK CALENDAR BUTTON
        androidImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Home.this, Calendar.class);
                startActivity(intentLoadNewActivity);
            }
        });

        //CLICK PILL BUTTON
        androidImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Home.this, Pills.class);
                startActivity(intentLoadNewActivity);
            }
        });

        //CLICK BUY BUTTON
        androidImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Home.this, Buy.class);
                startActivity(intentLoadNewActivity);
            }
        });

        //CLICK PROFILE BUTTON
        androidImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Home.this, Profile.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}