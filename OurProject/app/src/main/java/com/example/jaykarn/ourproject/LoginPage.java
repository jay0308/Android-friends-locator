package com.example.jaykarn.ourproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by JayKarn on 3/6/2016.
 */
public class LoginPage extends Activity {
    EditText username;
    Button login;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        username=(EditText)findViewById(R.id.usernameEt);
        login=(Button)findViewById(R.id.loginBtn);

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String getUsername = username.getText().toString();
                    if(getUsername==null||getUsername.equals("")) {
                        username.setError("login by name");

                    }
                    else{
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE);
                        editor=pref.edit();
                        editor.putString("username", getUsername);
                        editor.commit();
                        Intent i=new Intent(LoginPage.this,ServerAddressForm.class);
                        startActivity(i);
                        Intent openTest = new Intent("com.example.jaykarn.SERVERADDRESSFORM");
                        startActivity(openTest);
                        finish();
                    }
                }
            });

    }
}
