package edu.upf.pillup.HOME_ICONS;

import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.design.widget.Snackbar;
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

                SQLiteDatabase db = db_function.getWritableDatabase();

                Cursor row1 = db.rawQuery("select pills_name from pills where pills_name='" + enter_name + "'", null);
                String dbpill = "";
                if (row1.moveToFirst()) {
                    dbpill = row1.getString(0);
                }
                if (enter_name.equals(dbpill)) {
                    showSnackbar(findViewById(R.id.addpill_layout_id), "La pastilla ya existe", Snackbar.LENGTH_LONG);
                } else if (enter_name.isEmpty() || enter_freq.isEmpty() || enter_dur.isEmpty() || enter_time.isEmpty()){
                    showSnackbar(findViewById(R.id.addpill_layout_id), "Porfavor, rellena todos los campos", Snackbar.LENGTH_LONG);
                }else {

                    pill.setName(enter_name.trim());
                    pill.setFreq(enter_freq.trim());
                    pill.setTime(enter_dur.trim());
                    pill.setDur(enter_time.trim());
                    db_function.addPill(pill);
                    Intent intentLoadNewActivity = new Intent(Add_Pills.this, Pills.class);
                    startActivity(intentLoadNewActivity);
                }
            }
    });
    }
    public void showSnackbar(View view, String message, int duration){
        Snackbar.make(view, message, duration).show();
    }
}
