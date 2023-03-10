package com.example.animewatchlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AnimeWatchListRecyclerview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_watch_list_recyclerview);
        FloatingActionButton addAnime=findViewById(R.id.watchlist_floating_action_button_id);
        addAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        RecyclerView recyclerView=findViewById(R.id.anime_watch_list_recyclerview_id);
        List<AnimeWatchListRecyclerviewData> d=new ArrayList<>();
        d.add(new AnimeWatchListRecyclerviewData("Ffdf"));
        d.add(new AnimeWatchListRecyclerviewData("dgsgs"));
        AnimeWatchListAdapter animeWatchListAdapter =new AnimeWatchListAdapter(d);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(animeWatchListAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void openDialog() {
        AddAnimeDialouge addAnimeDialog=new AddAnimeDialouge();
        addAnimeDialog.show(getSupportFragmentManager(),"Add anime dialog");
    }
}