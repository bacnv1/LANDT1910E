package com.t3h.buoi12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.t3h.buoi12.adapter.SongAdapter;
import com.t3h.buoi12.databinding.ActivityMainBinding;
import com.t3h.buoi12.model.Song;
import com.t3h.buoi12.utils.SystemData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SystemData data;
    private ActivityMainBinding binding;
    private SongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        adapter = new SongAdapter(getLayoutInflater());
        binding.lvSong.setAdapter(adapter);

        data = new SystemData(this);
        adapter.setData(data.getData());
    }
}
