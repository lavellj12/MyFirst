package com.example.lavelljackson.myfirstapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lavelljackson.myfirstapp.model.User;

/**
 * Created by lavelljackson on 8/26/17.
 */
//Creating the database
public class Databasehelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_editName = "Name";
    public static final String COLUMN_ediUser = "Username";
    public static final String COLUMN_editPassword = "Password";
    public static final String COLUMN_ediConPass = "Confirm Password";
    public static final String COLUMN_ediEmail = "Email";
    public static final String COLUMN_editAge = "Age";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id interger primary key not null , " +
            "Name text not null, Username text not null, Password text not null, Confirm_Password text not null, " +
    "Email text not null, Age text not null);";


    //Creating the database
    public Databasehelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertUser(User u)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from Users";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_editName , u.getName());
        values.put(COLUMN_ediUser , u.getUsername());
        values.put(COLUMN_editPassword , u.getPassword());
        values.put(COLUMN_ediConPass , u.getConfirm_Password());
        values.put(COLUMN_ediEmail , u.getEmail());
        values.put(COLUMN_editAge , u.getAge());

        //Insert the users into the database
        db.insert(TABLE_NAME , null , values);
        db.close();

    }

    //Creating Database Login
    public String searchPass(String ediUser) {
        db = this.getReadableDatabase();
        String query = "select Username, Password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);


                if(a.equals(ediUser))
                {
                    b = cursor.getString(1);
                    break;

                }

            }
            while (cursor.moveToNext());
        }

        return b;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
