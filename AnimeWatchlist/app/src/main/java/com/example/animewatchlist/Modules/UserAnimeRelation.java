package com.example.animewatchlist.Modules;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"userID" , "name"})
public class UserAnimeRelation {
    public int userID;
    @NonNull
    public String name;
}
