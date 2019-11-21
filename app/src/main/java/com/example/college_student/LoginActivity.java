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

        getSupportActionBar().hide();

        login = (Button) findViewById(R.id.btnlogin);
        username = (EditText) findViewById(R.id.txtusername);
        password = (EditText) findViewById(R.id.txtpassword);

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
           String userName = username.getText().toString();
           String passWord = password.getText().toString();

           if(username.getText().toString().matches("")){
               username.setError("Enter Your Username");
               return;
           }
           if(password.getText().toString().matches("")){
               password.setError("Enter correct Password");
               return;
           }

           if(userName.equals("softwarica") && passWord.equals("coventry"))
           {
               Toast.makeText(getApplicationContext(), "Successfully Login",Toast.LENGTH_LONG).show();
               Intent intent = new Intent(this,MainActivity.class);
               startActivity(intent);
           }
           else
           {
               Toast.makeText(getApplicationContext(),"Incorrect Username OR Password",Toast.LENGTH_LONG).show();
           }
           username.getText().clear();
           password.getText().clear();


        
    }
}







