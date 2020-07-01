package com.t3h.buoi12.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.buoi12.databinding.ItemSongBinding;
import com.t3h.buoi12.model.Song;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    private LayoutInflater inflater;
    private ArrayList<Song> data;

    public SongAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(ArrayList<Song> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSongBinding binding =
                ItemSongBinding.inflate(inflater, parent, false);
        return new SongHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, int position) {
        holder.binding.setItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        private ItemSongBinding binding;
        public SongHolder(@NonNull ItemSongBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
