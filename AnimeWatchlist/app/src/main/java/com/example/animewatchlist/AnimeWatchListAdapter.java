package com.example.animewatchlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animewatchlist.Database.AppDatabase;
import com.example.animewatchlist.Database.UserDao;
import com.example.animewatchlist.Modules.Anime;
import com.example.animewatchlist.Modules.User;
import com.example.animewatchlist.Modules.UserAnimeRelation;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

    public class AnimeWatchListAdapter extends RecyclerView.Adapter<AnimeWatchListAdapter.ViewHolder> {
        List<Anime> animeWatchListRecyclerviewData;
        User user;

        public AnimeWatchListAdapter(List<Anime> animeWatchListRecyclerviewData , User user) {
            this.animeWatchListRecyclerviewData = animeWatchListRecyclerviewData;
            this.user = user;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_watch_list_card,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Anime animeWatchListRecyclerviewData1= animeWatchListRecyclerviewData.get(position);
            holder.animeWatchListTextView.setText(animeWatchListRecyclerviewData1.name);
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(holder.getAdapterPosition() , v.getContext());
                    notifyItemRemoved(holder.getAdapterPosition());
                }
            });


        }

        @Override
        public int getItemCount() {
            return animeWatchListRecyclerviewData.size();
        }

        public void deleteItem(int position , Context context) {
            Anime item;
            if(position==0) {
                item = animeWatchListRecyclerviewData.get(position);
                animeWatchListRecyclerviewData.remove(position);
            }
            else {
                item = animeWatchListRecyclerviewData.get(position - 1);
                animeWatchListRecyclerviewData.remove(position - 1);
            }

            UserAnimeRelation userAnimeRelation = new UserAnimeRelation();
            userAnimeRelation.uiD = user.uiD;
            userAnimeRelation.name = item.name;
            AppDatabase db = AppDatabase.getDb(context);
            UserDao userDao = db.userDao();
            userDao.deleteUserAnimeRelation(userAnimeRelation);
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView animeWatchListTextView;
            FloatingActionButton delete;
            public ViewHolder(@NonNull View animeWatchListView) {
                super(animeWatchListView);
                animeWatchListTextView =animeWatchListView.findViewById(R.id.anime_watch_later_card_text_id);
                delete = animeWatchListView.findViewById(R.id.remove_anime_id);
            }
        }
    }



