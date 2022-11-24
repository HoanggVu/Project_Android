package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.doantest.R;

public class ChangeInfo extends AppCompatActivity {

    private Button btnChange, btnBack;
    private EditText etName, etAccount, etPass, etPhone, etAddess;
    private ImageView imgViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_info);

        getID();
        setBack();
        setChange();
    }

    private void setChange() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentChange = new Intent(ChangeInfo.this, Profile.class);
                startActivity(intentChange);
            }
        });
    }

    private void setBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(ChangeInfo.this, Profile.class);
                startActivity(intentBack);
            }
        });
    }

    private void getID() {
        btnBack = findViewById(R.id.btn_back);
        btnChange = findViewById(R.id.btn_change);
    }
}