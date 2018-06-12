package edu.upf.pillup.CONTROLLERS;

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
import edu.upf.pillup.R;

/**
 * Created by yniangarcia on 24/05/2018.
 */

public class Login extends AppCompatActivity {

    Button login;
    Button register;

    EditText text4u,text4p;
    private Cursor row;
    private db_functions db_function = new db_functions(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.button);
        register = (Button) findViewById(R.id.Register);
        text4u = (EditText) findViewById(R.id.editText);
        text4p = (EditText) findViewById(R.id.editText2);

        //CLICK LOG IN BUTTON
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = db_function.getWritableDatabase();
                String enter_user = text4u.getText().toString();
                String enter_password = text4p.getText().toString();
                row = db.rawQuery("select user_name,user_pass from users where user_name='" + enter_user + "' and user_pass='" + enter_password + "'", null);
                //System.out.println(row.getString(0));
                if (row.getCount()==0){
                    showSnackbarlogin(findViewById(R.id.login_layout_id), "El usuario o la contraseña no son válidos", Snackbar.LENGTH_LONG);
                }
                if (row.moveToFirst()) {
                    String valid_u = row.getString(0);
                    String valid_p = row.getString(1);
                    if (enter_user.equals(valid_u) && enter_password.equals(valid_p)) {
                        showSnackbarlogin(findViewById(R.id.login_layout_id), "Inicio de sesión correcto", Snackbar.LENGTH_LONG);
                        text4u.setText("");
                        text4p.setText("");
                        Intent intentLoadNewActivity = new Intent(Login.this, Home.class);
                        startActivity(intentLoadNewActivity);
                    }
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Login.this, Sign_Up.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
    public void showSnackbarlogin(View view, String message, int duration){
        Snackbar.make(view, message, duration).show();
    }
}
