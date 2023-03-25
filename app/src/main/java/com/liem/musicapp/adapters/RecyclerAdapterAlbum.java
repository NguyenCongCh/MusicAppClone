package com.liem.musicapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liem.musicapp.R;
import com.liem.musicapp.activities.DanhSachBaiHatActivity;
import com.liem.musicapp.models.Album;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class RecyclerAdapterAlbum extends RecyclerView.Adapter<RecyclerAdapterAlbum.ViewHolder> {
    private Context context;
    private ArrayList<Album> albums;

    public RecyclerAdapterAlbum(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_album, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerAdapterAlbum.ViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.txtCaSi.setText(album.getTenCaSi());
        holder.txtAlbum.setText(album.getTenAlbum());
        Picasso.get().load(album.getHinhAnhAlbum()).into(holder.imgAlbum);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhSachBaiHatActivity.class);
                intent.putExtra("album", album);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
       return albums.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAlbum;
        TextView txtAlbum, txtCaSi;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.itemAlbum_imgAlbum);
            txtAlbum = itemView.findViewById(R.id.itemAlbum_txtAlbum);
            txtCaSi = itemView.findViewById(R.id.itemAlbum_txtCaSi);
        }
    }
}
