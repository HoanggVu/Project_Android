package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.doantest.R;

public class Profile extends AppCompatActivity {

    private Button btnChange, btnBack;
    private EditText etName, etAccount, etPass, etPhone, etAddess;
    private ImageView imgViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        getID();
        setChange();
        setBack();
    }

    private void setBack() {
        getID();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProduct = new Intent(Profile.this, MainActivity.class);
                startActivity(intentProduct);
            }
        });
    }

    private void setChange() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentChangeInfo = new Intent(Profile.this, ChangeInfo.class);
                startActivity(intentChangeInfo);
            }
        });
    }

    private void getID() {
        btnChange = findViewById(R.id.btn_change);
        btnBack = findViewById(R.id.btn_back);
    }
}