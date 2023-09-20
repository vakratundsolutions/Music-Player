package com.music.musicplayer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.music.musicplayer.R;
import com.music.musicplayer.databinding.ActivityMainBinding;
import com.music.musicplayer.databinding.ActivityMusicPlayerBinding;

import java.io.IOException;

public class MusicPlayerActivity extends AppCompatActivity {

    ActivityMusicPlayerBinding binding;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mediaPlayer = new MediaPlayer();
        String mp3FileTitle = getIntent().getStringExtra("mp3FileTitle");
        Log.e("TAG", "onCreate: ======mp3FileTitle"+mp3FileTitle );
        String mp3FileArtist = getIntent().getStringExtra("mp3FileArtist");
        Log.e("TAG", "onCreate: =======mp3FileArtist"+mp3FileArtist );

        try {
            mediaPlayer.setDataSource(mp3FileTitle);
            mediaPlayer.setDataSource(mp3FileArtist);
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_MEDIA).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();
            mediaPlayer.setAudioAttributes(audioAttributes);

            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }


        binding.BtnStart.setOnClickListener(view -> {
            if (isPlaying) {
                mediaPlayer.pause();
                binding.BtnStart.setText("Play");
            } else {
                mediaPlayer.start();
                binding.BtnStart.setText("Pause");
            }
            isPlaying = !isPlaying;
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}