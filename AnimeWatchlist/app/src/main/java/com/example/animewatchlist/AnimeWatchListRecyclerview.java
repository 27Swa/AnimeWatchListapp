package com.example.animewatchlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.animewatchlist.Database.AppDatabase;
import com.example.animewatchlist.Database.UserDao;
import com.example.animewatchlist.Modules.Anime;
import com.example.animewatchlist.Modules.User;
import com.example.animewatchlist.Modules.UserAnimeRelation;
import com.example.animewatchlist.Modules.UserWithAnime;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AnimeWatchListRecyclerview extends AppCompatActivity implements AddAnimeDialouge.AddAnimeDialogListener{

    //List<Anime> animes = new ArrayList<>();
    UserWithAnime UserAnimes = new UserWithAnime();
    UserAnimeRelation userAnimeRelation = new UserAnimeRelation();
    AppDatabase db = AppDatabase.getDb(this);
    UserDao userDao = db.userDao();
    int Uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_watch_list_recyclerview);
        String loggedInEmail = getIntent().getStringExtra("LoggedInUser");
        User LoggedInUser = new User();
        LoggedInUser = userDao.loadUserData(loggedInEmail);
        UserAnimes = userDao.getAnimewithuser(LoggedInUser.uiD);
        Uid = LoggedInUser.uiD;
        Button BTNLogout=findViewById(R.id.logoutButton);
        BTNLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

//                Intent logout=new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(logout);
//                finish();
                AlertDialog alertDialog = new AlertDialog.Builder(AnimeWatchListRecyclerview.this).create();
                alertDialog.setTitle("Log out!");
                alertDialog.setMessage("Are you sure you want to log out?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent logout=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(logout);
                        finish();
                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();

            }
        });
        FloatingActionButton addAnime=findViewById(R.id.watchlist_floating_action_button_id);
        addAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        RecyclerView recyclerView=findViewById(R.id.anime_watch_list_recyclerview_id);
//        List<AnimeWatchListRecyclerviewData> d=new ArrayList<>();
//        d.add(new AnimeWatchListRecyclerviewData("Ffdf"));
//        d.add(new AnimeWatchListRecyclerviewData("dgsgs"));
        AnimeWatchListAdapter animeWatchListAdapter =new AnimeWatchListAdapter(UserAnimes.animeList , LoggedInUser);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(animeWatchListAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void openDialog() {
        AddAnimeDialouge addAnimeDialog=new AddAnimeDialouge();
        addAnimeDialog.show(getSupportFragmentManager(),"Add anime dialog");
    }

    @Override
    public void applyText(String addAnime) {
        Anime anime = new Anime();
        anime.name = addAnime;
        UserAnimes.animeList.add(anime);
        userDao.insertAnime(anime);
        userAnimeRelation.name = anime.name;
        userAnimeRelation.uiD = Uid;
        userDao.insertUserAnimeRelation(userAnimeRelation);
        //animes.add(anime);
    }
}