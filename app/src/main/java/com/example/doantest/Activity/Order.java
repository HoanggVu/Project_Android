package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doantest.Activity.Product.OrderAdapter;
import com.example.doantest.R;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {
    private Button btnDat, btnBack;
    private RecyclerView rcvOrder;
    private OrderAdapter orderAdapter;
    private TextView tvPriceTotal, tvPriceItem, tvPriceCharges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        getID();
        setDat();
        setBack();
        setOrder();
        Calculator();
    }

    private void Calculator() {
        getID();
    }

    private void setOrder() {
        getID();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvOrder.setLayoutManager(linearLayoutManager);

        orderAdapter.setData(getListOrder(), new OrderAdapter.IClickDelete() {
            @Override
            public void OnClickDelete(ImageView imgDelete, com.example.doantest.Activity.Product.Order product) {
                Toast.makeText(Order.this, "Check", Toast.LENGTH_SHORT).show();
            }
        });
        rcvOrder.setAdapter(orderAdapter);
    }

    private List<com.example.doantest.Activity.Product.Order> getListOrder() {
        List<com.example.doantest.Activity.Product.Order> list = new ArrayList<>();
        list.add(new com.example.doantest.Activity.Product.Order(R.drawable.cardview1, "name", "25.000 VND"));
        list.add(new com.example.doantest.Activity.Product.Order(R.drawable.cardview2, "name", "25.000 VND"));
        list.add(new com.example.doantest.Activity.Product.Order(R.drawable.carview3, "name", "25.000 VND"));

        list.add(new com.example.doantest.Activity.Product.Order(R.drawable.cardview1, "name", "25.000 VND"));
        list.add(new com.example.doantest.Activity.Product.Order(R.drawable.cardview2, "name", "25.000 VND"));

        return list;
    }

    private void setBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(Order.this, MainActivity.class);
                startActivity(intentBack);
            }
        });
    }

    private void setDat() {
        btnDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Order.this, "Check", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getID() {
        btnDat = findViewById(R.id.btn_dat);
        btnBack = findViewById(R.id.btn_back);
        rcvOrder = findViewById(R.id.rcv_order);
        tvPriceItem = findViewById(R.id.tv_price_item);
        tvPriceCharges = findViewById(R.id.tv_price_charges);
        tvPriceTotal = findViewById(R.id.tv_price_total);
        orderAdapter = new OrderAdapter();
    }
}