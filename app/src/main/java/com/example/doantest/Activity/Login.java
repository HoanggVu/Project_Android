package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.doantest.R;

public class Login extends AppCompatActivity {

    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getID();
        setLogin();
    }

    private void setLogin() {
        getID();
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProduct = new Intent(Login.this, MainActivity.class);
                startActivity(intentProduct);
            }
        });
    }

    private void getID() {
        txtLogin = findViewById(R.id.txtLogin);
    }
}