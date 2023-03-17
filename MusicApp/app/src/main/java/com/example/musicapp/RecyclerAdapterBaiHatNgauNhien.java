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
import com.liem.musicapp.activities.PlayNhacActivity;
import com.liem.musicapp.models.BaiHat;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapterBaiHatNgauNhien extends RecyclerView.Adapter<RecyclerAdapterBaiHatNgauNhien.ViewHolder> {
    private Context context;
    private ArrayList<BaiHat> baiHatArrayList;

    public RecyclerAdapterBaiHatNgauNhien(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_bai_hat_ngau_nhien, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerAdapterBaiHatNgauNhien.ViewHolder holder, int position) {
        BaiHat baiHat = baiHatArrayList.get(position);
        holder.txtCaSi.setText(baiHat.getTenCaSi() );
        holder.txtBaiHat.setText(baiHat.getTenBaiHat());
        Picasso.get().load(baiHat.getHinhAnhBaiHat()).into(holder.imgBaiHat);

        holder.imgLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayNhacActivity.class);
                intent.putExtra("baiHat", baiHat);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBaiHat, imgLove;
        TextView txtBaiHat, txtCaSi;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgBaiHat = itemView.findViewById(R.id.itemBaiHatNgauNhien_imgBaiHat);
            imgLove = itemView.findViewById(R.id.itemBaiHatNgauNhien_txtCaSi_icLove);
            txtBaiHat = itemView.findViewById(R.id.itemBaiHatNgauNhien_txtBaiHat);
            txtCaSi = itemView.findViewById(R.id.itemBaiHatNgauNhien_txtCaSi);
        }
    }
}
