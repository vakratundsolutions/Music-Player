package com.music.musicplayer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.music.musicplayer.R;
import com.music.musicplayer.databinding.ActivityMainBinding;
import com.music.musicplayer.databinding.ActivityRecentBinding;

public class RecentActivity extends AppCompatActivity {

    ActivityRecentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.text.setText("");
    }
}