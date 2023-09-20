package com.music.musicplayer.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.music.musicplayer.R;
import com.music.musicplayer.databinding.ItemMp3Binding;
import com.music.musicplayer.model.Mp3File;

import java.util.List;

public class Mp3Adapter extends RecyclerView.Adapter<Mp3Adapter.ViewHolder> {
    private List<Mp3File> mp3Files;
    private Context context;

    public Mp3Adapter(Context context, List<Mp3File> mp3Files) {
        this.context = context;
        this.mp3Files = mp3Files;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ItemMp3Binding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mp3File mp3File = mp3Files.get(position);
        holder.binding.fileNameTextView.setText(mp3File.getFileName());
        Log.e("TAG", "onBindViewHolder:=====getFileName " + mp3File.getFileName());
        holder.binding.filePathTextView.setText(mp3File.getFilePath());
        Log.e("TAG", "onBindViewHolder:=====getFilePath " + mp3File.getFilePath());
    }

    @Override
    public int getItemCount() {
        return mp3Files.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemMp3Binding binding;

        public ViewHolder(ItemMp3Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}