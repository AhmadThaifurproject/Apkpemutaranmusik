package com.kelompok8.apkpemutaranmusik;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {
    private List<Playlist> playlistList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public ImageView thumbnailImageView;

        public ViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.titleTextView);
            thumbnailImageView = view.findViewById(R.id.thumbnailImageView);
        }
    }

    public PlaylistAdapter(List<Playlist> playlistList) {
        this.playlistList = playlistList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playlist, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Playlist playlist = playlistList.get(position);
        holder.titleTextView.setText(playlist.getTitle());
        holder.thumbnailImageView.setImageResource(playlist.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return playlistList.size();
    }
}
