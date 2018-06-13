package edu.upf.pillup.HOME_ICONS;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.graphics.Color;
import android.os.SystemClock;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CalendarView;

import java.text.ParseException;

import edu.upf.pillup.CONTROLLERS.Home;
import edu.upf.pillup.CONTROLLERS.Login;
import edu.upf.pillup.R;

public class Calendar extends AppCompatActivity {

    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_button);

        calendarView = (CalendarView) findViewById(R.id.calendarView);



    }
}

