package com.example.animewatchlist.Modules;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"uiD" , "name"})
public class UserAnimeRelation {
    public int uiD;
    @NonNull
    public String name;
}
