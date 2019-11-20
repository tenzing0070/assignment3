package com.example.college_student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        login = (Button) findViewById(R.id.btnlogin);
        username = (EditText) findViewById(R.id.txtusername);
        password = (EditText) findViewById(R.id.txtpassword);

        login.setOnClickListener(new View.OnClickListener() {




    @Override
    public void onClick(View v) {
            if (username.getText().toString().equals("softwarica") && password.getText().toString().equals("coventry")) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                username.requestFocus();
            }
        }
    });
        }

    @Override
    public void onClick(View v) {
        
    }
}







