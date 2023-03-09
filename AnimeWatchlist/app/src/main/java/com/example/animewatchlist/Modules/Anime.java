package com.example.animewatchlist.Modules;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Anime {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    public String name;
}
