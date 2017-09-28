package com.example.lavelljackson.myfirstapp.activities;
/**
 * This is the register Page
 * You come to this page to sign up on the app,
 * before logging in
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lavelljackson.myfirstapp.R;
import com.example.lavelljackson.myfirstapp.database.Databasehelper;
import com.example.lavelljackson.myfirstapp.model.User;

//Sign Up Page
public class register extends AppCompatActivity {

    Databasehelper helper = new Databasehelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onregisterClick(View v)
    {

        if(v.getId()== R.id.btnDoneRegister)
        {
            EditText Name = (EditText)findViewById(R.id.editName);
            EditText Username = (EditText)findViewById(R.id.ediUser);
            EditText Password = (EditText)findViewById(R.id.ediPass);
            EditText Confirm_Password = (EditText)findViewById(R.id.ediConPass);
            EditText Email = (EditText)findViewById(R.id.ediEmail);
            EditText Age = (EditText)findViewById(R.id.editAge);

            String Namestr = Name.getText().toString();
            String Usernamestr =  Username.getText().toString();
            String Passwordstr =  Password.getText().toString();
            String Confirm_Passwordstr = Confirm_Password.getText().toString();
            String Emailstr = Email.getText().toString();
            String Agestr = Age.getText().toString();

            if(!Passwordstr.equals(Confirm_Passwordstr))
            {

               Toast pass = Toast.makeText(register.this , "Passwords do not match!!" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //Enter the details to the database
                User u = new User();
                u.setName(Namestr);
                u.setUsername(Usernamestr);
                u.setPassword(Passwordstr);
                u.setConfirm_Password(Confirm_Passwordstr);
                u.setEmail(Emailstr);
                u.setAge(Agestr);

                helper.insertUser(u);




            }


        }

    }

}

