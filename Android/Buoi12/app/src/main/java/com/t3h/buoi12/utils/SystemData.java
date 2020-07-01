package com.t3h.buoi12.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.util.Log;

import com.t3h.buoi12.model.Song;

import java.util.ArrayList;

public class SystemData {
    private ContentResolver resolver;

    public SystemData(Context context) {
        resolver = context.getContentResolver();
    }

    public ArrayList<Song> getData() {
//        ContactsContract.Contacts.CONTENT_URI
//        Telephony.Sms.CONTENT_URI
//        CallLog.CONTENT_URI
//        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
//        MediaStore.Audio.Media.INTERNAL_CONTENT_URI
        ArrayList<Song> arr = new ArrayList<>();
        Cursor cursor = resolver.query(
                MediaStore.Audio.Media.INTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();

        int indexData = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA);
        int indexSize = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE);
        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE);
        int indexDuration = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST);
        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM);
        while (cursor.isAfterLast() == false) {
//            for (int i = 0; i < cursor.getColumnCount(); i++) {
//                Log.e(cursor.getColumnName(i), cursor.getString(i) + "");
//            }
//            Log.e("=============", "==================");
            String data = cursor.getString(indexData);
            int size = cursor.getInt(indexSize);
            int duration = cursor.getInt(indexDuration);
            String title = cursor.getString(indexTitle);
            String artist = cursor.getString(indexArtist);
            String album = cursor.getString(indexAlbum);
            Song song = new Song();
            song.setAlbum(album);
            song.setArtist(artist);
            song.setData(data);
            song.setDuration(duration);
            song.setSize(size);
            song.setTitle(title);
            arr.add(song);
            cursor.moveToNext();
        }
        cursor.close();
        return arr;
    }
}
