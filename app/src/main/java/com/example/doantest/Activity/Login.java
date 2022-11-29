package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doantest.Activity.User.User;
import com.example.doantest.Activity.User.UserDAO;
import com.example.doantest.Activity.User.UserDatabase;
import com.example.doantest.R;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {


    private EditText edtLoginName, edtLoginPass;
    private TextView txtLogin, txtBack;
    private List<User> mListUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getID();
        setLogin();
        setBack();
    }

    private void setBack() {
        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMain = new Intent(Login.this, Intro.class);
                startActivity(intentMain);
            }
        });
    }

    private void setLogin() {
        getID();
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getLogin();
            }
        });
    }

    private void getLogin() {
        String strLoginName = edtLoginName.getText().toString().trim();
        String strLoginPass = edtLoginPass.getText().toString().trim();

        if(TextUtils.isEmpty(strLoginName) || TextUtils.isEmpty(strLoginPass)){
            Toast.makeText(this, "Enter Your Email And Password", Toast.LENGTH_SHORT).show();
        }
        else{
            UserDatabase userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "user.db").allowMainThreadQueries().build();
            mListUser = userDatabase.userDAO().getUser();
            for (User list: mListUser){
                if(!strLoginName.equals(list.getEmail())){
                    Toast.makeText(this, "ERROR Account", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (!strLoginPass.equals(list.getPassword())){
                    Toast.makeText(this, "ERROR Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Bundle bundle = new Bundle();
                    bundle.putInt("ID_LOGIN", list.getId());
                    Intent intentProduct = new Intent(Login.this, MainActivity.class);
                    intentProduct.putExtras(bundle);
                    startActivity(intentProduct);
                    Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
    }

    private void getID() {

        txtLogin = findViewById(R.id.txtLogin);
        edtLoginName = findViewById(R.id.edtLoginName);
        edtLoginPass = findViewById(R.id.edtLoginPass);
        txtBack = findViewById(R.id.txtLoginBack);
    }
}