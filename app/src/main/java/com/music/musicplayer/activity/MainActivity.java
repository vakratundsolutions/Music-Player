package com.music.musicplayer.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.music.musicplayer.Fragment.PlaylistFragment;
import com.music.musicplayer.Fragment.LibraryFragment;
import com.music.musicplayer.Fragment.HomeFragment;
import com.music.musicplayer.Fragment.SearchFragment;
import com.music.musicplayer.R;
import com.music.musicplayer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment(new HomeFragment());
        binding.navigation.setOnNavigationItemSelectedListener(this);
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
                fragment = new SearchFragment();
                break;
        }

        return loadFragment(fragment);
    }

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.f_fregment, fragment).commit();
            return true;
        }
        return false;
    }

}