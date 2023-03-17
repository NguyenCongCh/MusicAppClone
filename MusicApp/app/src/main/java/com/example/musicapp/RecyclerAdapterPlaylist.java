package com.liem.musicapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.liem.musicapp.R;
import com.liem.musicapp.activities.DanhSachBaiHatActivity;
import com.liem.musicapp.models.Playlist;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapterPlaylist extends RecyclerView.Adapter<RecyclerAdapterPlaylist.ViewHolder> {

    private Context context;
    private ArrayList<Playlist> playlists;
    private RecyclerView recyclerView;


    public RecyclerAdapterPlaylist(Context context, ArrayList<Playlist> playlists, RecyclerView recyclerView) {
        this.context = context;
        this.playlists = playlists;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerAdapterPlaylist.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_playlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerAdapterPlaylist.ViewHolder holder, int position) {
        Playlist playlist = playlists.get(position);
        Picasso.get().load(playlist.getHinhNen()).into(holder.imgBackground);
        Picasso.get().load(playlist.getHinhIcon()).into(holder.imgIcon);
        holder.txtPlaylist.setText(playlist.getTen());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("playlist", playlist);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return playlists.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBackground, imgIcon;
        TextView txtPlaylist;
        ConstraintLayout layout;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgBackground = itemView.findViewById(R.id.itemPlaylist_background);
            imgIcon = itemView.findViewById(R.id.itemPlaylist_icon);
            txtPlaylist = itemView.findViewById(R.id.itemPlaylist_txtPlaylist);
            layout = itemView.findViewById(R.id.itemPlaylist_layout);
        }
    }

}
