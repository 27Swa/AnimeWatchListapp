package com.example.animewatchlist.Modules;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class AnimeWithUser {
    @Embedded Anime anime;
    @Relation(
            parentColumn = "name",
            entityColumn = "userID" ,
            associateBy = @Junction(UserAnimeRelation.class)
    )
    public List<User> userList;
}
