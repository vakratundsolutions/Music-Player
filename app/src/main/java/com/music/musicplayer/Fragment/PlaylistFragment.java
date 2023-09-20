package com.music.musicplayer.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.music.musicplayer.adapter.Mp3Adapter;
import com.music.musicplayer.databinding.FragmentPlaylistBinding;
import com.music.musicplayer.model.Mp3File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistFragment extends Fragment {

    FragmentPlaylistBinding binding;
    private List<Mp3File> mp3Files = new ArrayList<>();
    Mp3Adapter mp3Adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlaylistBinding.inflate(inflater, container, false);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        try {
            String[] assetFiles = getContext().getAssets().list("");
            for (String fileName : assetFiles) {
                if (fileName.endsWith(".mp3")) {
                    mp3Files.add(new Mp3File(fileName, "file:///android_asset/" + fileName));

                }
            }
            mp3Adapter = new Mp3Adapter(getContext(), mp3Files);
            Log.e("TAG", "onCreateView: " + mp3Files.size());
            binding.recyclerView.setAdapter(mp3Adapter);
            mp3Adapter.notifyDataSetChanged();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return binding.getRoot();
    }

    public void openMp3File(Mp3File mp3File) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("file:///android_asset/" + mp3File.getFilePath());
        intent.setDataAndType(uri, "audio/*");
        startActivity(intent);
    }
}