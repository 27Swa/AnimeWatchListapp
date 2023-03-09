package com.example.animewatchlist.Modules;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Anime {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
