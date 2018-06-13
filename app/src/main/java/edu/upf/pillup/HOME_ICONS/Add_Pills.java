package edu.upf.pillup.HOME_ICONS;

import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.upf.pillup.DATABASE.db_functions;
import edu.upf.pillup.DATABASE.modelPills;
import edu.upf.pillup.R;

public class Add_Pills extends AppCompatActivity {

    Button add;
    private modelPills pill = new modelPills();
    private db_functions db_function = new db_functions(this);
    EditText pill_name,pill_freq,pill_dur,pill_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pills);
        add = (Button)findViewById(R.id.Save);
        pill_name = (EditText)findViewById(R.id.PillName);
        pill_freq = (EditText)findViewById(R.id.Duracion);
        pill_dur = (EditText)findViewById(R.id.Frequency);
        pill_time = (EditText)findViewById(R.id.AddTime);
        //CLICK SAVE BUTTON
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String enter_name = pill_name.getText().toString();
                String enter_freq = pill_freq.getText().toString();
                String enter_dur = pill_dur.getText().toString();
                String enter_time = pill_time.getText().toString();

                System.out.println(enter_name+enter_freq+enter_time+enter_dur);

                pill.setName(enter_name.trim());
                pill.setFreq(enter_freq.trim());
                pill.setTime(enter_dur.trim());
                pill.setDur(enter_time.trim());
                System.out.println(pill);
                db_function.addPill(pill);
                Intent intentLoadNewActivity = new Intent(Add_Pills.this, Pills.class);
                startActivity(intentLoadNewActivity);
            }
    });
    }
}
