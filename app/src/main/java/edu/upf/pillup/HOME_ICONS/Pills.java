package edu.upf.pillup.HOME_ICONS;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.database.Cursor;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.upf.pillup.DATABASE.db_functions;

import edu.upf.pillup.CONTROLLERS.Home;
import edu.upf.pillup.CONTROLLERS.Login;
import edu.upf.pillup.R;

public class Pills extends AppCompatActivity {

    Button add;
    db_functions myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_button);

        add = (Button)findViewById(R.id.add_pill);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLoadNewActivity = new Intent(Pills.this, Add_Pills.class);
                startActivity(intentLoadNewActivity);

            }
        });


        ListView listView = (ListView) findViewById(R.id.listView);
        myDB = new db_functions(this);

        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListPills();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }



    }

}
