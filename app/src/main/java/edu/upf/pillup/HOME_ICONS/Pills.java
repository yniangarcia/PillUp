package edu.upf.pillup.HOME_ICONS;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.upf.pillup.R;

public class Pills extends AppCompatActivity {

    Button add;

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

    }

}
