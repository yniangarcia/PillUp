package edu.upf.pillup.HOME_ICONS;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import edu.upf.pillup.R;

import static android.graphics.Color.parseColor;

public class Profile extends AppCompatActivity {

    ImageView ImageProfile;
    private EditText NameSurname;
    private EditText EmailUser;
    private EditText PassUser;

    private TextView textout;
    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_button);

        //IMAGE OF THE PROFILE
        ImageProfile = (ImageView) findViewById(R.id.user);

        //SET YOUR NAME AND SURNAME
        NameSurname = (EditText) findViewById(R.id.Name);
        NameSurname.getBackground().mutate().setColorFilter(parseColor("#616768"), PorterDuff.Mode.SRC_ATOP);
        NameSurname.setText(NameSurname.getText());

        // SPINNER GENDER
        dropdown = findViewById(R.id.Gender);
        String[] items = new String[]{"Sexo","Femenino", "Masculino"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, items);
        dropdown.setAdapter(adapter);

        //CHANGE EMAIL
        EmailUser = (EditText) findViewById(R.id.UserEmail);
        EmailUser.getBackground().mutate().setColorFilter(parseColor("#616768"), PorterDuff.Mode.SRC_ATOP);
        EmailUser.setText(EmailUser.getText());

        //CHANGE PASSWORD
        PassUser = (EditText) findViewById(R.id.Password);
        PassUser.getBackground().mutate().setColorFilter(parseColor("#616768"), PorterDuff.Mode.SRC_ATOP);
        PassUser.setText(PassUser.getText());

        //CHANGE PASSWORD
        PassUser = (EditText) findViewById(R.id.Password);
        PassUser.getBackground().mutate().setColorFilter(parseColor("#616768"), PorterDuff.Mode.SRC_ATOP);
        PassUser.setText(PassUser.getText());

    }

}

