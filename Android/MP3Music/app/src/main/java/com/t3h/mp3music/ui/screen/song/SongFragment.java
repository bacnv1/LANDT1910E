package com.t3h.mp3music.ui.screen.song;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.mp3music.R;
import com.t3h.mp3music.databinding.FragmentSongBinding;
import com.t3h.mp3music.models.Song;
import com.t3h.mp3music.ui.base.BaseBindingAdapter;
import com.t3h.mp3music.ui.base.BaseFragment;
import com.t3h.mp3music.ui.screen.album.AlbumViewModel;

public class SongFragment extends BaseFragment<FragmentSongBinding, SongViewModel> {

    private BaseBindingAdapter<Song> adapter;

    @Override
    protected Class<SongViewModel> getViewModelClass() {
        return SongViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_song;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseBindingAdapter<>(
                R.layout.item_song, getLayoutInflater());
        binding.setAdapter(adapter);
        adapter.setData(viewModel.getSong(getContext()));
    }
}
