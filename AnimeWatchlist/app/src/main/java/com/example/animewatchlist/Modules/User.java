package com.example.animewatchlist.Modules;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uiD;

    @ColumnInfo(name = "firstname")
    public String first_name;

    @ColumnInfo(name = "lastname")
    public String last_name;

    @ColumnInfo(name = "Email")
    public String email;

    @ColumnInfo(name="password")
    public String password;

}
