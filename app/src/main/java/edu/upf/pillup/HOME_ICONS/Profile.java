package edu.upf.pillup.HOME_ICONS;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import edu.upf.pillup.CONTROLLERS.Home;
import edu.upf.pillup.CONTROLLERS.Sign_Up;
import edu.upf.pillup.DATABASE.db_functions;
import edu.upf.pillup.R;

import static android.graphics.Color.parseColor;

public class Profile extends AppCompatActivity {

    ImageView ImageProfile;
    private EditText NameSurname;
    private EditText EmailUser;
    private EditText PassUser;
    Spinner dropdown;
    Button save;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_button);

        //IMAGE OF THE PROFILE
        ImageProfile = (ImageView) findViewById(R.id.user);

        //SET YOUR NAME AND SURNAME
        NameSurname = (EditText) findViewById(R.id.Name);

        // SPINNER GENDER
        dropdown = findViewById(R.id.Gender);
        String[] items = new String[]{"Sexo","Femenino", "Masculino"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, items);
        dropdown.setAdapter(adapter);

        //CHANGE EMAIL
        EmailUser = (EditText) findViewById(R.id.UserEmail);

        //CHANGE PASSWORD
        PassUser = (EditText) findViewById(R.id.Password);

        ImageButton loadImage = (ImageButton) findViewById(R.id.user);
        loadImage.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }});

        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Home.class);
                startActivity(intent);
            }
        });

    }
}

