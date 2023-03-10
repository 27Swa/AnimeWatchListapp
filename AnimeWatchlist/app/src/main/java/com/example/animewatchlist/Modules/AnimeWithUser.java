package com.example.animewatchlist.Modules;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class AnimeWithUser {
    @Embedded public Anime anime;
    @Relation(
            parentColumn = "name",
            entityColumn = "uiD" ,
            associateBy = @Junction(UserAnimeRelation.class)
    )
    public List<User> userList;
}
