package com.example.lavelljackson.myfirstapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lavelljackson.myfirstapp.R;
import com.example.lavelljackson.myfirstapp.database.Databasehelper;

import static com.example.lavelljackson.myfirstapp.R.*;

/**Clement Lavell Jackson III
 * August 25, 2017
 */

//Main Page "Log In & Sign Up"
public class MainActivity extends AppCompatActivity {
    Databasehelper myDb;
    Databasehelper helper = new Databasehelper(this);

    //Creating a final string named Tag that is MainActivity
    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        myDb = new Databasehelper(this);
        Log.d(TAG, "onCreate: Starting.");

        //Logging In button
        Button button5 = (Button) findViewById(id.button5);

        //Click the button to go to the login page
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked button5.");

                EditText a = (EditText)findViewById(R.id.ediUser);
                String str = a.getText().toString();
                EditText b = (EditText)findViewById(R.id.ediPass);
                String pass = b.getText().toString();

                String password = helper.searchPass(str);
                if(pass.equals(password))
                {
                    Intent i = new Intent(MainActivity.this, login.class);
                    i.putExtra("Username",str);
                    startActivity(i);
                }
                else
                {
                    Toast temp = Toast.makeText(MainActivity.this , "Passwords do not match!!" , Toast.LENGTH_SHORT);
                    temp.show();
                }




            }
        });

        Button button6 = (Button) findViewById(id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked button6.");

                Intent intent = new Intent(MainActivity.this, register.class);
                startActivity(intent);
            }

        });
    }

}
