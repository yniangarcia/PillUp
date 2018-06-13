package edu.upf.pillup.HOME_ICONS;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import edu.upf.pillup.R;

public class Calendar extends AppCompatActivity {

    CalendarView calendarView;
    PopupWindow mPopupWindow;
    EditText dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_button);

        //Get calendar component
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        //on change date event listener
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {

                //Create a new instance of the popup menu
                // Initialize a new instance of LayoutInflater service
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

                // Inflate the custom layout/view
                View customView = inflater.inflate(R.layout.activity_popup_menu,null);

                // Initialize a new instance of popup window
                mPopupWindow = new PopupWindow(
                        customView,
                        LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT
                );

                // Get a reference for the custom view close button
                ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);

                // Get a reference for the custom view text
                EditText dateText = (EditText) customView.findViewById(R.id.selectedDateField);
                //Bind calendar date
                dateText.setText("    "+i2+" - "+i1+" - "+i);

                // Set a click listener for the popup window close button
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });

                mPopupWindow.showAtLocation(findViewById(R.id.rl), Gravity.CENTER, 0, 0);
            }
        });
    }

    public void showSnackbarlogin(View view, String message, int duration){
        Snackbar.make(view, message, duration).show();
    }
}
