package com.t3h.buoi12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.SearchView;

import com.t3h.buoi12.adapter.SongAdapter;
import com.t3h.buoi12.databinding.ActivityMainBinding;
import com.t3h.buoi12.model.Song;
import com.t3h.buoi12.utils.SystemData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongAdapter.SongItemClickLister, MainListener, SearchView.OnQueryTextListener {

    private SystemData data;
    private ActivityMainBinding binding;
    private SongAdapter adapter;
    private MediaController mediaController;

    private String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        if (checkPermission()) {
            init();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(PERMISSIONS, 0);
            }
        }
    }

    private void init() {
        adapter = new SongAdapter(getLayoutInflater());
        binding.lvSong.setAdapter(adapter);
        data = new SystemData(this);
        songs = data.getData();
        adapter.setData(songs);
        adapter.setLister(this);
        binding.setListener(this);
        mediaController = new MediaController(songs, this){
            @Override
            public void create(int index) {
                super.create(index);
                binding.setTitle(songs.get(index).getTitle());
            }

            @Override
            public void start() {
                super.start();
                binding.setIsPlaying(true);
            }

            @Override
            public void pause() {
                super.pause();
                binding.setIsPlaying(false);
            }
        };

        binding.search.setOnQueryTextListener(this);
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : PERMISSIONS) {
                if (checkSelfPermission(p) == PackageManager.PERMISSION_DENIED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()) {
            init();
        }
    }

    @Override
    public void onSongItemClicked(Song item) {
        int index = songs.indexOf(item);
        mediaController.create(index);
    }

    @Override
    public void onNext() {
        mediaController.change(1);
    }

    @Override
    public void onPrev() {
        mediaController.change(-1);
    }

    @Override
    public void onMediaPause() {
        if (binding.getIsPlaying()) {
            mediaController.pause();
        } else {
            mediaController.start();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return true;
    }
}
