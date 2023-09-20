package com.music.musicplayer.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;

public class Mp3SongsFinder {

    public static ArrayList<File> getMp3Songs(Context context) {
        ArrayList<File> songsList = new ArrayList<>();

        Uri allSongsUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        Cursor cursor = context.getContentResolver().query(allSongsUri, null, selection, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String fullpath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    File songFile = new File(fullpath);
                    if (songFile.exists() && songFile.isFile()) {
                        songsList.add(songFile);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        return songsList;
    }
}