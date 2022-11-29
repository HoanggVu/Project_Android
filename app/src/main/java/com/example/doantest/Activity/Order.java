package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doantest.Activity.Product.OrderAdapter;
import com.example.doantest.Activity.User.User;
import com.example.doantest.Activity.User.UserDatabase;
import com.example.doantest.R;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {
    private Button btnDat, btnBack;
    private RecyclerView rcvOrder;
    private OrderAdapter orderAdapter;
    private List<User> mListUser;
    private Order order;
    private TextView tvPriceTotal, tvPriceItem, tvPriceCharges, txtName, txtPhone, txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        getID();
        setDat();
        setBack();
        setOrder();
        Calculator();
        setProfile();


    }

    private void setProfile() {
        Bundle extras = getIntent().getExtras();
        UserDatabase userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "user.db").allowMainThreadQueries().build();
        mListUser = userDatabase.userDAO().getUser();
        for (User list: mListUser) {
            if (list.getId() == extras.getInt("ID_LOGIN_ORDER")){

                txtName.setText(list.getUsername());
                txtPhone.setText(list.getPhone());
                txtAddress.setText(list.getAddress());
            }
        }
    }

    private void Calculator() {

    }

    private void setOrder() {
        getID();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvOrder.setLayoutManager(linearLayoutManager);

        orderAdapter.setData(getListOrder(), new OrderAdapter.IClickDelete() {
            @Override
            public void OnClickDelete(ImageView imgDelete, com.example.doantest.Activity.Product.Order product) {
                Toast.makeText(Order.this, "Đã Xóa Khỏi Giỏ Hàng", Toast.LENGTH_SHORT).show();
            }
        });
        rcvOrder.setAdapter(orderAdapter);
    }

    private List<com.example.doantest.Activity.Product.Order> getListOrder() {
        List<com.example.doantest.Activity.Product.Order> list = new ArrayList<>();
        list.add(new com.example.doantest.Activity.Product.Order(R.drawable.cardview1, "Trà Sữa Trân Trâu", "30.000 VND"));
        list.add(new com.example.doantest.Activity.Product.Order(R.drawable.cardview2, "Trà Sửa Matcha", "35.000 VND"));
        list.add(new com.example.doantest.Activity.Product.Order(R.drawable.cardview3, "Nước Cam", "49.000 VND"));
        return list;
    }

    private void setBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setDat() {
        btnDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Order.this, "Đặt Hàng Thành Công!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getID() {
        btnDat = findViewById(R.id.btn_dat);
        btnBack = findViewById(R.id.btn_back);
        rcvOrder = findViewById(R.id.rcv_order);
        txtName = findViewById(R.id.txtUserName);
        txtPhone = findViewById(R.id.txtUserPhone);
        txtAddress = findViewById(R.id.txtUserAddress);
        tvPriceItem = findViewById(R.id.tv_price_item);
        tvPriceCharges = findViewById(R.id.tv_price_charges);
        tvPriceTotal = findViewById(R.id.tv_price_total);
        orderAdapter = new OrderAdapter();
    }
}