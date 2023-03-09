package com.example.animewatchlist.Modules;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UserWithAnime {
    @Embedded User user;
    @Relation(
            parentColumn = "userID" ,
            entityColumn = "name" ,
            associateBy = @Junction(UserAnimeRelation.class)
    )
    public List<Anime> animeList;
}
