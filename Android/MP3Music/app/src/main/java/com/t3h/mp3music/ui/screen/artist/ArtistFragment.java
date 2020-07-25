package com.t3h.mp3music.ui.screen.artist;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.t3h.mp3music.R;
import com.t3h.mp3music.databinding.FragmentArtitstBinding;
import com.t3h.mp3music.databinding.FragmentSongBinding;
import com.t3h.mp3music.models.Artist;
import com.t3h.mp3music.models.Song;
import com.t3h.mp3music.ui.base.BaseBindingAdapter;
import com.t3h.mp3music.ui.base.BaseFragment;
import com.t3h.mp3music.ui.screen.song.SongViewModel;

public class ArtistFragment extends BaseFragment<FragmentArtitstBinding, ArtistViewModel> {

    private BaseBindingAdapter<Artist> adapter;

    @Override
    protected Class<ArtistViewModel> getViewModelClass() {
        return ArtistViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_artitst;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseBindingAdapter<>(
                R.layout.item_artist, getLayoutInflater());
        binding.setAdapter(adapter);
        adapter.setData(viewModel.getArtist(getContext()));
    }
}
