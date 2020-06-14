package com.t3h.buoi8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.t3h.buoi8.fragment.FavoriteFragment;
import com.t3h.buoi8.fragment.NewsFragment;
import com.t3h.buoi8.fragment.SavedFragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager pager;
    private TabLayout tab;
    private NewsPagerAdapter adapter;

    private NewsFragment fmNews = new NewsFragment();
    private SavedFragment fmSaved = new SavedFragment();
    private FavoriteFragment fmFavorite = new FavoriteFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        pager = findViewById(R.id.view_pager);
        tab = findViewById(R.id.tab);
        tab.setupWithViewPager(pager);
        adapter = new NewsPagerAdapter(getSupportFragmentManager(), fmNews, fmSaved, fmFavorite);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.e(getClass().getName(), position + "");
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
