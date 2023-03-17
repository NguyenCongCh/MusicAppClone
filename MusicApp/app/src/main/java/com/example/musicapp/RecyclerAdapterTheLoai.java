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
import com.liem.musicapp.models.ChuDe;
import com.liem.musicapp.models.TheLoai;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapterTheLoai extends RecyclerView.Adapter<RecyclerAdapterTheLoai.ViewHolder> {
    private Context mContext;
    private ArrayList<TheLoai> theLoaiArrayList;

    public RecyclerAdapterTheLoai(Context mContext, ArrayList<TheLoai> theLoaiArrayList) {
        this.mContext = mContext;
        this.theLoaiArrayList = theLoaiArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_theloai, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerAdapterTheLoai.ViewHolder holder, int position) {
        TheLoai theLoai = theLoaiArrayList.get(position);
        holder.txtTheLoai.setText(theLoai.getTenTheLoai());
        Picasso.get().load(theLoai.getHinhTheLoai()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DanhSachBaiHatActivity.class);
                intent.putExtra("theLoai", theLoai);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return theLoaiArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTheLoai;
        ImageView img;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtTheLoai = itemView.findViewById(R.id.itemTheloai_txtTheloai);
            img = itemView.findViewById(R.id.itemTheloai_img);
        }
    }
}
