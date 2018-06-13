package edu.upf.pillup.DATABASE;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.upf.pillup.DATABASE.modelUser;

public class db_functions extends SQLiteOpenHelper{

    private static final int DB_version = 3;
    private static final String DB_name = "PillUp.db";

    private static final String table_user = "users";
    private static final String column_user_id = "user_id";
    private static final String column_user_name = "user_name";
    private static final String column_user_surname = "user_surname";
    private static final String column_user_mail = "user_mail";
    private static final String column_user_pass = "user_pass";

    private static final String table_pills = "pills";
    private static final String column_pills_id = "pills_id";
    private static final String column_pills_name = "pills_name";
    private static final String column_pills_freq = "pills_freq";
    private static final String column_pills_dur = "pills_dur";
    private static final String column_pills_time = "pills_time";


    private String create_user_query = "create table "+ table_user + " ( "+column_user_id
            +" integer primary key autoincrement,"+column_user_name+" text,"+column_user_surname+" text,"
            +column_user_mail+" text,"+column_user_pass+" text)";

    private String drop_user_table_query = "drop table if exists "+ table_user;

    private String create_pill_query = "create table "+ table_pills + " ( "+column_pills_id
            +" integer primary key autoincrement,"+column_pills_name+" text,"+column_pills_dur+" text,"
            +column_pills_time+" text,"+column_pills_freq+" text)";

    private String drop_pills_table_query = "drop table if exists "+ table_pills;

    public db_functions(Context context ) {
        super(context, DB_name, null, DB_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_user_query);
        System.out.println("------------------- in in in in in");
        db.execSQL(create_pill_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(drop_user_table_query);
        db.execSQL(drop_pills_table_query);
        onCreate(db);
    }

    public void registerUser(modelUser user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(column_user_name, user.getName());
        values.put(column_user_surname, user.getSurname());
        values.put(column_user_mail, user.getEmail());
        values.put(column_user_pass, user.getPassword());

        db.insert(table_user, null, values);
        db.close();
    }

    public void addPill(modelPills pill){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(column_pills_name, pill.getName());
        values.put(column_pills_dur, pill.getDur());
        values.put(column_pills_time, pill.getTime());
        values.put(column_pills_freq, pill.getFreq());

        db.insert(table_pills, null, values);
        db.close();
    }

    //public List<modelUser>

    public List<modelUser> getRegistredUsers() {
        // array of columns to fetch
        String[] columns = {
                column_user_id,
                column_user_name,
                column_user_surname,
                column_user_mail,
                column_user_pass
        };
        // sorting orders
        String sortOrder =
                column_user_name + " ASC";
        List<modelUser> userList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(table_user,
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                modelUser user = new modelUser();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(column_user_id))));
                user.setName(cursor.getString(cursor.getColumnIndex(column_user_name)));
                user.setSurname(cursor.getString(cursor.getColumnIndex(column_user_surname)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(column_user_mail)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(column_user_pass)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }


    public List<modelPills> getAllPills() {
        // array of columns to fetch
        String[] columns = {
                column_pills_id,
                column_pills_name,
                column_pills_dur,
                column_pills_time,
                column_pills_freq
        };
        // sorting orders
        String sortOrder =
                column_pills_name + " ASC";
        List<modelPills> pillsList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(table_pills,
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                modelPills pill = new modelPills();
                pill.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(column_pills_id))));
                pill.setName(cursor.getString(cursor.getColumnIndex(column_pills_name)));
                pill.setTime(cursor.getString(cursor.getColumnIndex(column_pills_time)));
                pill.setDur(cursor.getString(cursor.getColumnIndex(column_pills_dur)));
                pill.setFreq(cursor.getString(cursor.getColumnIndex(column_pills_freq)));
                // Adding user record to list
                pillsList.add(pill);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return pillsList;
    }

    public Cursor getListPills(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT "+column_pills_name+ " FROM " + table_pills, null);
        return data;
    }
}
