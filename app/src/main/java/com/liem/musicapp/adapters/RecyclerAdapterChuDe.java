package com.liem.musicapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liem.musicapp.R;
import com.liem.musicapp.models.ChuDe;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapterChuDe extends RecyclerView.Adapter<RecyclerAdapterChuDe.ViewHolder> {
    private Context mContext;
    private ArrayList<ChuDe> chuDeArrayList;

    public RecyclerAdapterChuDe(Context mContext, ArrayList<ChuDe> chuDeArrayList) {
        this.mContext = mContext;
        this.chuDeArrayList = chuDeArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_chude, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerAdapterChuDe.ViewHolder holder, int position) {
        ChuDe chuDe = chuDeArrayList.get(position);
        holder.txtChude.setText(chuDe.getTenChuDe());
        Picasso.get().load(chuDe.getHinhChuDe()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return chuDeArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtChude;
        ImageView img;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtChude = itemView.findViewById(R.id.itemChude_txtChude);
            img = itemView.findViewById(R.id.itemChude_img);
        }
    }
}
