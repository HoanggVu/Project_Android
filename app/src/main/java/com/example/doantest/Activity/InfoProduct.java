package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.doantest.R;

public class InfoProduct extends AppCompatActivity {

    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_product);

        getID();
        AddtoCard();

    }

    private void AddtoCard() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCart = new Intent(InfoProduct.this, Order.class);
                startActivity(intentCart);
            }
        });
    }

    private void getID() {
        btnAdd = findViewById(R.id.btn_Add);
    }
}