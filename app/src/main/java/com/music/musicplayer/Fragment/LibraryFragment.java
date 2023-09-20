package com.music.musicplayer.Fragment;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.music.musicplayer.adapter.MusicAdapter;
import com.music.musicplayer.databinding.FragmentLibraryBinding;
import com.music.musicplayer.model.MusicFile;

import java.util.ArrayList;

public class LibraryFragment extends Fragment {

    FragmentLibraryBinding binding;
    ArrayList<MusicFile> musicFiles = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLibraryBinding.inflate(inflater, container, false);

//        ArrayList<File> songsList = Mp3SongsFinder.getMp3Songs(getContext());
//
//        if (songsList.isEmpty()) {
//            // The permission is not granted.
//            Toast.makeText(getContext(), "The READ_EXTERNAL_STORAGE permission is required to get the list of .mp3 files.", Toast.LENGTH_SHORT).show();
//
//        }
//
//        for (File songFile : songsList) {
//            System.out.println(songFile.getAbsolutePath());
//        }
        setAdapter();
        getMusic();

        return binding.getRoot();
    }
    private void getMusic() {
        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA
        };

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = requireContext().getContentResolver().query(uri, projection, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                @SuppressLint("Range") String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));

                musicFiles.add(new MusicFile(id, title, artist, data));
                Log.e("TAG", "onCreateView:id " + id);
                Log.e("TAG", "onCreateView:title " + title);
                Log.e("TAG", "onCreateView:artist " + artist);
            }
            cursor.close();
        }
    }

    private void setAdapter() {
        MusicAdapter musicAdapter = new MusicAdapter(getContext(), musicFiles);
        binding.recyclerView.setAdapter(musicAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}