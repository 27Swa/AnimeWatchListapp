package com.example.animewatchlist.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.animewatchlist.Modules.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE Email = :email")
    User loadUserData(String email);

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM User")
    void DeleteAll();
}
