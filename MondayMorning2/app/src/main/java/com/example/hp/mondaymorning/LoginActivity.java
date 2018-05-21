package com.example.hp.mondaymorning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button login;
    private Button signup;
    private TextView forgotb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        name = (EditText)findViewById(R.id.LoginName);
        password = (EditText)findViewById(R.id.LoginPass);
        login = (Button)findViewById(R.id.LoginB);
        signup=(Button)findViewById(R.id.LoginSignupB);
        forgotb=(TextView)findViewById(R.id.ForgotB);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,Signup.class));
            }
        });
    }

    private void validate(String username, String userpassword)
    {
         startActivity(new Intent(LoginActivity.this,Signup.class));
    }
}
