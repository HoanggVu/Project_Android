package com.example.doantest.Activity;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doantest.Activity.User.User;
import com.example.doantest.Activity.User.UserDatabase;
import com.example.doantest.R;

import java.util.List;

public class Profile extends AppCompatActivity {

    private Button btnChange, btnBack;
    private TextView txtName, txtEmail, txtPass, txtPhone, txtAddess;
    private ImageView imgViewInfo;
    private List<User> mListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        getID();
        setChange();
        setBack();
        setProfile();
        setResultt();
    }

    private void setResultt() {

        Intent intent = getIntent();
        Bundle bundleProfile = intent.getExtras();
        if(bundleProfile != null){
            loadData();
            for (User list: mListUser) {
                if (list.getId() == bundleProfile.getInt("ID_RESULT_PROFILE")){

                    txtName.setText(list.getUsername());
                    txtEmail.setText(list.getEmail());
                    txtPass.setText(list.getPassword());
                    txtPhone.setText(list.getPhone());
                    txtAddess.setText(list.getAddress());

                }
            }
        }
    }

    private void setProfile() {
        Intent intent = getIntent();
        Bundle bundleProfile = intent.getExtras();
        if(bundleProfile != null){
            loadData();
            for (User list: mListUser) {
                if (list.getId() == bundleProfile.getInt("ID_LOGIN_PROFILE")){

                    txtName.setText(list.getUsername());
                    txtEmail.setText(list.getEmail());
                    txtPass.setText(list.getPassword());
                    txtPhone.setText(list.getPhone());
                    txtAddess.setText(list.getAddress());

                }
            }
        }
    }

    private void loadData(){
        UserDatabase userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "user.db").allowMainThreadQueries().build();
        mListUser = userDatabase.userDAO().getUser();
    }

    private void setBack() {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setChange() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundleChangeProfile = intent.getExtras();
                if (bundleChangeProfile != null){
                    int idChangeProfile = bundleChangeProfile.getInt("ID_LOGIN_PROFILE");
                    Intent intentChangeInfo = new Intent(Profile.this, ChangeInfo.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("ID_CHANGE_PROFILE", idChangeProfile);
                    intentChangeInfo.putExtras(bundle);
                    startActivity(intentChangeInfo);
                }
            }
        });
    }

    private void getID() {
        btnChange = findViewById(R.id.btn_change);
        btnBack = findViewById(R.id.btn_back);
        txtName = findViewById(R.id.txtNameProfile);
        txtEmail = findViewById(R.id.txtEmailProfile);
        txtPass = findViewById(R.id.txtPassProfile);
        txtPhone = findViewById(R.id.txtPhoneProfile);
        txtAddess = findViewById(R.id.txtAddressProfile);
    }
}