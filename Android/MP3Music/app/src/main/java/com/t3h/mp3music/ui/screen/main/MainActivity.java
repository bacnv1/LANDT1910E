package com.t3h.mp3music.ui.screen.main;

import android.Manifest;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.t3h.mp3music.R;
import com.t3h.mp3music.databinding.ActivityMainBinding;
import com.t3h.mp3music.models.Artist;
import com.t3h.mp3music.ui.base.BaseActivity;
import com.t3h.mp3music.ui.base.BaseFragment;
import com.t3h.mp3music.ui.screen.album.AlbumFragment;
import com.t3h.mp3music.ui.screen.artist.ArtistFragment;
import com.t3h.mp3music.ui.screen.song.SongFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements BottomNavigationView.OnNavigationItemSelectedListener {

    private AlbumFragment fmAlbum = new AlbumFragment();
    private SongFragment fmSong = new SongFragment();
    private ArtistFragment fmArtist = new ArtistFragment();

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    protected void init() {
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        requestPermission(permissions, new PermissionListener() {
            @Override
            public void onResult(boolean isGranted) {
                if (isGranted) {
                    binding.bottomNav.setOnNavigationItemSelectedListener(MainActivity.this);
                    initFragment();
                    showFragment(fmSong);
                } else {
                    finish();
                }
            }
        });
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fmAlbum);
        transaction.add(R.id.container, fmSong);
        transaction.add(R.id.container, fmArtist);
        transaction.commit();
    }

    private void showFragment(BaseFragment fmShow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
        transaction.hide(fmAlbum);
        transaction.hide(fmSong);
        transaction.hide(fmArtist);

        transaction.show(fmShow);
        transaction.commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_song:
                showFragment(fmSong);
                break;
            case R.id.nav_artist:
                showFragment(fmArtist);
                break;
            case R.id.nav_album:
                showFragment(fmAlbum);
                break;
        }
        return true;
    }
}
