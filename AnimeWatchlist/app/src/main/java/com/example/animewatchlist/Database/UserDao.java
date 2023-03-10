package com.example.animewatchlist.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.animewatchlist.Modules.Anime;
import com.example.animewatchlist.Modules.User;
import com.example.animewatchlist.Modules.UserAnimeRelation;
import com.example.animewatchlist.Modules.UserWithAnime;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE Email = :email")
    User loadUserData(String email);

    @Insert
    void insertUser(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAnime(Anime anime);

    @Insert
    void insertUserAnimeRelation(UserAnimeRelation uar);

    @Delete
    void deleteUser(User user);

//    @Transaction
//    @Query("SELECT * FROM Anime WHERE  name= :animeName")
//    Anime getUserwithanime(String animeName);
//
//    @Transaction
//    @Query("SELECT * FROM User WHERE uiD= :id")
//    User getAnimewithuser(int id);

    @Transaction
    @Query("SELECT * FROM User WHERE uiD= :id")
    UserWithAnime getAnimewithuser(int id);

    @Query("DELETE FROM User")
    void DeleteAll();
}
