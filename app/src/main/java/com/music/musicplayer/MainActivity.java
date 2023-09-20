package com.music.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.music.musicplayer.Fregments.PlaylistFragment;
import com.music.musicplayer.Fregments.LibraryFragment;
import com.music.musicplayer.Fregments.HomeFragment;
import com.music.musicplayer.Fregments.ExploreFragment;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout f_fregment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id_binding();

        //loading the default fragment
        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);


    }

    void id_binding() {
        f_fregment = findViewById(R.id.f_fregment);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_dashboard:
                fragment = new PlaylistFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new LibraryFragment();
                break;

            case R.id.navigation_profile:
                fragment = new ExploreFragment();
                break;
        }

        return loadFragment(fragment);
    }

    public boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.f_fregment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}