package com.music.musicplayer.Fregments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.music.musicplayer.R;
import com.music.musicplayer.Utils.Mp3SongsFinder;

import java.io.File;
import java.util.ArrayList;


public class LibraryFragment extends Fragment {


    private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_library, container, false);



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

//        ListView audioView = (ListView) view.findViewById(R.id.list);
//
//        ArrayList<String> audioList = new ArrayList<>();
//
//        String[] proj = { MediaStore.Audio.Media._ID,MediaStore.Audio.Media.DISPLAY_NAME  };// Can include more data for more details and check it.
//
//        Cursor audioCursor = getContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, proj, null, null, null);
//
//        if(audioCursor != null){
//            if(audioCursor.moveToFirst()){
//                do{
//                    int audioIndex = audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
//
//                    audioList.add(audioCursor.getString(audioIndex));
//
//                }while(audioCursor.moveToNext());
//            }
//        }
//        audioCursor.close();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,android.R.id.text1, audioList);
//        audioView.setAdapter(adapter);




        return view;
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CODE_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // The READ_EXTERNAL_STORAGE permission was granted.
                // Get the MP3 songs from storage.
                ArrayList<File> songsList = Mp3SongsFinder.getMp3Songs(getContext());

                // Do something with the songsList ArrayList.
            } else {
                // The READ_EXTERNAL_STORAGE permission was denied.
                // Handle the denied permission here.
            }
        }
    }
}