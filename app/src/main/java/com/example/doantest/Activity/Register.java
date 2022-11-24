package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.doantest.R;

public class Register extends AppCompatActivity {

    private TextView txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        getID();
        setSignUp();
    }

    private void setSignUp() {
        getID();
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(Register.this, Login.class);
                startActivity(intentLogin);
            }
        });
    }

    private void getID() {
        txtSignUp = findViewById(R.id.txtSignUp);
    }
}