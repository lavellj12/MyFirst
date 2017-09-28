/** Clement Lavell Jackson III
 * 8/27/17 1:49am
 * I been working on this I promise.
 * I need the app to move away from Admin and 1234
 * and start pulling accounts from the "Databasehelper"
 */


package com.example.lavelljackson.myfirstapp.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lavelljackson.myfirstapp.R;

import java.util.Objects;

//The login page of PhoneSweeper. When tapping the "Log In"
//Enter Username: Admin
//Enter Password: 1234
public class login extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Done;
    private int counter = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Declaring "Username" as ediUser (id)
        Username = (EditText)findViewById(R.id.ediUser);
        //Declaring "Password" as ediUser (id)
        Password = (EditText)findViewById(R.id.ediPass);
        //Declaring "Info" as tvInfo
        Info = (TextView)findViewById(R.id.tvInfo);
        //Creating "Done" button
        Done = (Button)findViewById(R.id.btnDone);


        //Validating the "Username" & "Password" to get the input text
        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText() .toString(), Password.getText() .toString());
            }
        });
    }

    private void validate(String userName, String userPassword){

        //Creating Username: Admin And Password: 1234
        if((Objects.equals(userName, "Admin")) && (Objects.equals(userPassword, "1234"))) {

            //If successful it will proceed to the next page
            Intent intent = new Intent(login.this, Successpage.class);
            startActivity(intent);

        }else{

            //THe counter to change
            counter--;

            //If you enter the password wrong the number of attepts changers
            Info.setText("Number of attempts: " + String.valueOf(counter));

            if(counter == 0){
                Done.setEnabled(true);
            }

        }
    }
}
