package com.example.doantest.Activity.Product;

import androidx.room.Database;
import androidx.room.RoomDatabase;

public abstract class OrderDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "order.db";
    private static OrderDatabase instance;


}
