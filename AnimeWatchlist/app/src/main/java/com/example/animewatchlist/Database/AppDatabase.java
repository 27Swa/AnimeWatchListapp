package com.example.animewatchlist.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.animewatchlist.Modules.User;

@Database(entities = {User.class} , version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase db;
    public abstract UserDao userDao();

    public static AppDatabase getDb(Context context) {
        if(db==null){
             db = Room.databaseBuilder(context,
            AppDatabase.class, "UserData").allowMainThreadQueries()
                                                .build();
        }
        return db;
    }
}


