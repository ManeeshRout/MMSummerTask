package com.example.hp.mondaymorning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    private EditText username,useremail,userpass;
    private Button signupb;
    private TextView backb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupUIViews();
        signupb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    String user_email=useremail.getText().toString().trim();
                    String user_pass=userpass.getText().toString().trim();

                    //Upload data to database

                }
            }
        });
        backb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this,LoginActivity.class));
            }
        });
    }
    private void setupUIViews()
    {
        username = (EditText)findViewById(R.id.SignupText);
        userpass = (EditText)findViewById(R.id.SignupPass);
        useremail =(EditText)findViewById(R.id.SignupEmail);
        signupb=(Button)findViewById(R.id.LoginSignupB);
        backb=(TextView)findViewById(R.id.SignupBack);
    }
    private Boolean validate()
    {
        Boolean result= false;
        String name = username.getText().toString();
        String password= userpass.getText().toString();
        String mail= useremail.getText().toString();

        if(name.isEmpty() || password.isEmpty() || mail.isEmpty()) {
            Toast.makeText(this,"Please enter all the details",Toast.LENGTH_SHORT).show();
        } else {
            result = false;
        }
        return result;
    }
}
