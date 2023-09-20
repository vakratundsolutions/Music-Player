package com.music.musicplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.music.musicplayer.R;
import com.music.musicplayer.activity.MusicPlayerActivity;
import com.music.musicplayer.databinding.ItemMp3Binding;
import com.music.musicplayer.model.MusicFile;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MusicFile> musicFiles;

    public MusicAdapter(Context context, ArrayList<MusicFile> musicFiles) {
        this.context = context;
        this.musicFiles = musicFiles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ItemMp3Binding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.fileNameTextView.setText(musicFiles.get(position).getTitle());
        holder.binding.filePathTextView.setText(musicFiles.get(position).getArtist());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, MusicPlayerActivity.class);
            intent.putExtra("mp3FileTitle", musicFiles.get(position).getTitle());
            intent.putExtra("mp3FileArtist", musicFiles.get(position).getArtist());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        Log.e("TAG", "getItemCount: " + musicFiles.size());
        return musicFiles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMp3Binding binding;

        public ViewHolder(ItemMp3Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}