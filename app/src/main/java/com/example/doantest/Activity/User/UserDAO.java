package com.example.doantest.Activity.User;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void ínsertUser(User user);

    @Query("SELECT * FROM user")
    List<User> getUser();

    @Query("SELECT * FROM user where email = :email")
    List<User> checkUser(String email);


    @Update()
    void updateUser(User user);
}
