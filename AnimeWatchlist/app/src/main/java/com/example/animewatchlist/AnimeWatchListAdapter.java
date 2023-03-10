package com.example.animewatchlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class AnimeWatchListAdapter extends RecyclerView.Adapter<AnimeWatchListAdapter.ViewHolder> {
        List<AnimeWatchListRecyclerviewData> animeWatchListRecyclerviewData;

        public AnimeWatchListAdapter(List<AnimeWatchListRecyclerviewData> animeWatchListRecyclerviewData) {
            this.animeWatchListRecyclerviewData = animeWatchListRecyclerviewData;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_watch_list_card,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            AnimeWatchListRecyclerviewData animeWatchListRecyclerviewData1= animeWatchListRecyclerviewData.get(position);
            holder.animeWatchListTextView.setText(animeWatchListRecyclerviewData1.animeWatchListData);

        }

        @Override
        public int getItemCount() {
            return animeWatchListRecyclerviewData.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView animeWatchListTextView;
            public ViewHolder(@NonNull View animeWatchListView) {
                super(animeWatchListView);
                animeWatchListTextView =animeWatchListView.findViewById(R.id.anime_watch_later_card_text_id);
            }
        }
    }



