package com.example.doantest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doantest.Activity.User.User;
import com.example.doantest.Activity.User.UserDatabase;
import com.example.doantest.R;

import java.util.List;

public class ChangeInfo extends AppCompatActivity {

    private Button btnChange, btnBack;
    private EditText edtChangeName, edtChangePass, edtChangePhone, edtChangeAddess;
    private TextView txtChangeEmail;
    private ImageView imgViewInfo;
    private List<User> mListUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_info);

        getID();
        setData();
        setChange();
        setBack();

    }

    private void setData() {
        Intent intent = getIntent();
        Bundle bundleChangeProfile = intent.getExtras();
        if (bundleChangeProfile != null){
            UserDatabase userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "user.db").allowMainThreadQueries().build();
            mListUser = userDatabase.userDAO().getUser();
            for (User list: mListUser) {
                if (list.getId() == bundleChangeProfile.getInt("ID_CHANGE_PROFILE")){

                    edtChangeName.setText(list.getUsername());
                    txtChangeEmail.setText(list.getEmail());
                    edtChangePass.setText(list.getPassword());
                    edtChangePhone.setText(list.getPhone());
                    edtChangeAddess.setText(list.getAddress());

                }
            }
        }
    }

    private void setChange() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeProfile();
            }
        });
    }

    private void ChangeProfile() {
        String strUsername = edtChangeName.getText().toString().trim();
        String strEmail = txtChangeEmail.getText().toString().trim();
        String strPass = edtChangePass.getText().toString().trim();
        String strPhone = edtChangePhone.getText().toString().trim();
        String strAddress = edtChangeAddess.getText().toString().trim();

        if(TextUtils.isEmpty(strUsername) || TextUtils.isEmpty(strEmail) ||
                TextUtils.isEmpty(strPass) || TextUtils.isEmpty(strPhone) || TextUtils.isEmpty(strAddress)){
            return;
        }


        Intent intent = getIntent();
        Bundle bundleChangeProfile = intent.getExtras();
        if (bundleChangeProfile != null) {
            UserDatabase userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "user.db").allowMainThreadQueries().build();
            mListUser = userDatabase.userDAO().getUser();
            for (User list : mListUser) {
                if (list.getId() == bundleChangeProfile.getInt("ID_CHANGE_PROFILE")) {
                    list.setUsername(strUsername);
                    list.setPassword(strPass);
                    list.setPhone(strPhone);
                    list.setAddress(strAddress);
                    UserDatabase.getInstance(this).userDAO().updateUser((list));
                }
            }
            Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show();
            Intent intentResult = getIntent();
            Bundle bundleResult = intentResult.getExtras();
            if (bundleResult != null) {
                int idLoginProfile = bundleResult.getInt("ID_CHANGE_PROFILE");
                Intent intentResultProfile = new Intent(ChangeInfo.this, Profile.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID_RESULT_PROFILE", idLoginProfile);
                intentResultProfile.putExtras(bundle);
                startActivity(intentResultProfile);
            }
            finish();
        }
    }

    private void setBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void getID() {
        btnBack = findViewById(R.id.btn_back);
        btnChange = findViewById(R.id.btn_change);
        edtChangeName = findViewById(R.id.edtChangeName);
        txtChangeEmail = findViewById(R.id.txtChangeEmail);
        edtChangePass = findViewById(R.id.edtChangePass);
        edtChangePhone = findViewById(R.id.edtChangePhone);
        edtChangeAddess = findViewById(R.id.edtChangeAddress);
    }
}