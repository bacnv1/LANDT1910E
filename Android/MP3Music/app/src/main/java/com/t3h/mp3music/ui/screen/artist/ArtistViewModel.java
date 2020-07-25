package com.t3h.mp3music.ui.screen.artist;

import android.content.Context;

import com.t3h.mp3music.models.Artist;
import com.t3h.mp3music.models.Song;
import com.t3h.mp3music.ui.base.BaseViewModel;
import com.t3h.mp3music.utils.SystemData;

import java.util.ArrayList;

public class ArtistViewModel extends BaseViewModel {
    private ArrayList<Artist> artists;

    public ArrayList<Artist> getArtist(Context context) {
        if (artists == null) {
            SystemData data = new SystemData(context);
            artists = data.getData(Artist.class);
        }
        return artists;
    }

}
