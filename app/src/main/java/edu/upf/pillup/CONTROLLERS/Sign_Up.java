package edu.upf.pillup.CONTROLLERS;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.Snackbar;

import edu.upf.pillup.DATABASE.db_functions;
import edu.upf.pillup.DATABASE.modelUser;
import edu.upf.pillup.R;

public class Sign_Up extends AppCompatActivity{

    Button sign_up;
    private modelUser user = new modelUser();
    private db_functions db_function = new db_functions(this);

    EditText text_name,text_surname,text_mail,text_pass,text_pass2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sign_up = (Button)findViewById(R.id.sign_up);
        text_name = (EditText)findViewById(R.id.name);
        text_surname = (EditText)findViewById(R.id.surname);
        text_mail = (EditText)findViewById(R.id.email);
        text_pass = (EditText)findViewById(R.id.password);
        text_pass2 = (EditText)findViewById(R.id.rp_password);
        SQLiteDatabase db = db_function.getWritableDatabase();
        //CLICK LOG IN BUTTON
        sign_up.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SQLiteDatabase db = db_function.getWritableDatabase();
                String enter_name = text_name.getText().toString();
                String enter_surname = text_surname.getText().toString();
                String enter_email = text_mail.getText().toString();
                String enter_pass = text_pass.getText().toString();
                String enter_pass2 = text_pass2.getText().toString();
                Cursor row1 = db.rawQuery("select user_name from users where user_name='" + enter_name + "'", null);
                Cursor row2 = db.rawQuery("select user_surname from users where user_surname='" + enter_surname + "'", null);
                String dbuser = "";
                String dbsurname = "";
                if (row1.moveToFirst()) { dbuser = row1.getString(0); }
                if (row2.moveToFirst()) { dbsurname = row2.getString(0); }

                if (!enter_pass.equals(enter_pass2)) {
                    text_pass.setText("");
                    text_pass2.setText("");
                    showSnackbar(findViewById(R.id.signup_layout_id), "Las contraseñas no se corresponden", Snackbar.LENGTH_LONG);
                }else if((text_pass.equals(text_pass2)) && (text_pass.length()<5)) {
                    text_pass.setText("");
                    text_pass2.setText("");
                    showSnackbar(findViewById(R.id.signup_layout_id), "Longitud de la contraseña no válida", Snackbar.LENGTH_LONG);
                }else if(!(text_pass.equals(text_pass2)) && (text_pass.length()<5)){
                    text_pass.setText("");
                    text_pass2.setText("");
                    showSnackbar(findViewById(R.id.signup_layout_id), "Las contraseñas no se corresponden y la longitud de la contraseña no es válida", Snackbar.LENGTH_LONG);
                } else if (enter_name.equals(dbuser) && enter_surname.equals(dbsurname)) {
                    showSnackbar(findViewById(R.id.signup_layout_id), "El usuario "+enter_name+" "+enter_surname+" ya existe!", Snackbar.LENGTH_LONG);
                    text_name.setText("");
                    text_surname.setText("");
                    text_mail.setText("");
                    text_pass.setText("");
                    text_pass2.setText("");
                }else if (enter_name.isEmpty() || enter_surname.isEmpty() || enter_email.isEmpty() || enter_pass.isEmpty()|| enter_pass2.isEmpty()){
                    showSnackbar(findViewById(R.id.signup_layout_id), "Porfavor, rellena todos los campos", Snackbar.LENGTH_LONG);
                }else if(isEmailValid(enter_email)==false) {
                    text_mail.setText("");
                    showSnackbar(findViewById(R.id.signup_layout_id), "Email incorrecto", Snackbar.LENGTH_LONG);
                }else {
                    user.setName(enter_name.trim());
                    user.setSurname(enter_surname.trim());
                    user.setEmail(enter_email.trim());
                    user.setPassword(enter_pass.trim());
                    db_function.registerUser(user);
                    showSnackbar(findViewById(R.id.signup_layout_id), "Usuario registrado correctamente", Snackbar.LENGTH_LONG);
                    Handler handlerGoToLogin = new Handler();
                    handlerGoToLogin.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intentLoadNewActivity = new Intent(Sign_Up.this, Login.class);
                            startActivity(intentLoadNewActivity);
                        }
                    }, 3000);
                }
                row1.close();
                row2.close();
            }
        });
    }
    public void showSnackbar(View view, String message, int duration){
        Snackbar.make(view, message, duration).show();
    }
    public static boolean isEmailValid(String enter_email) {
        return !(enter_email == null || TextUtils.isEmpty(enter_email)) && android.util.Patterns.EMAIL_ADDRESS.matcher(enter_email).matches();
    }

}
