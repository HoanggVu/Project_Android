package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doantest.Activity.User.User;
import com.example.doantest.Activity.User.UserDatabase;
import com.example.doantest.R;

import java.util.List;

public class Register extends AppCompatActivity {

    private EditText etName, etEmail, etPass, etPhone, etAddress;
    private List<User> mListUser;
    private TextView txtSignUp, txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        getID();
        setSignUp();
        setBack();
    }

    private void setBack() {
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setSignUp() {
        getID();
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addUser();
            }
        });
    }

    private void addUser() {
        String strUsername = etName.getText().toString().trim();
        String strEmail = etEmail.getText().toString().trim();
        String strPass = etPass.getText().toString().trim();
        String strPhone = etPhone.getText().toString().trim();
        String strAddress = etAddress.getText().toString().trim();

        if(TextUtils.isEmpty(strUsername) || TextUtils.isEmpty(strEmail) ||
                TextUtils.isEmpty(strPass) || TextUtils.isEmpty(strPhone) || TextUtils.isEmpty(strAddress)){
            return;
        }
        User user = new User(strUsername, strEmail, strPass, strPhone, strAddress);
        
        if (isUserExit(user)){
            Toast.makeText(this, "Email đã tồn tại", Toast.LENGTH_SHORT).show();
            return;
        }
        
        UserDatabase.getInstance(this).userDAO().ínsertUser(user);

        Intent intentLogin = new Intent(Register.this, Login.class);
        startActivity(intentLogin);
        Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show();

    }

    private boolean isUserExit(User user){
        List<User> list = UserDatabase.getInstance(this).userDAO().checkUser(user.getEmail());
        return  list != null && !list.isEmpty();
    }

    private void getID() {

        txtSignUp = findViewById(R.id.txtSignUp);
        etName = findViewById(R.id.edtName);
        etEmail = findViewById(R.id.edtEmail);
        etPass = findViewById(R.id.edtPass);
        etPhone = findViewById(R.id.edtPhone);
        etAddress = findViewById(R.id.edtAddress);
        txtBack = findViewById(R.id.txtRegisterBack);
    }
}