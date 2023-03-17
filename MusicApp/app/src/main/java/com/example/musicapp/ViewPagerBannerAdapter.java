package com.liem.musicapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.liem.musicapp.R;
import com.liem.musicapp.activities.DanhSachBaiHatActivity;
import com.liem.musicapp.models.QuangCao;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class ViewPagerBannerAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<QuangCao> mListQuangCao;

    public ViewPagerBannerAdapter(Context mContext, ArrayList<QuangCao> mListQuangCao) {
        this.mContext = mContext;
        this.mListQuangCao = mListQuangCao;
    }

    @Override
    public int getCount() {
        return mListQuangCao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Object instantiateItem(@NonNull @org.jetbrains.annotations.NotNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_banner, null);

        ImageView imgBackground = view.findViewById(R.id.itemBanner_backgroundBanner);
        ImageView imgPoster = view.findViewById(R.id.itemBanner_posterBanner);
        TextView txtTitle = view.findViewById(R.id.itemBanner_txtTitleBanner);
        TextView txtContent = view.findViewById(R.id.itemBanner_txtContentBanner);

        Picasso.get().load(mListQuangCao.get(position).getHinhAnhQuangCao()).into(imgBackground);
        Picasso.get().load(mListQuangCao.get(position).getHinhAnhBaiHat()).into(imgPoster);
        txtTitle.setText(mListQuangCao.get(position).getTenBaiHat());
        txtContent.setText(mListQuangCao.get(position).getNoiDung());

        container.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DanhSachBaiHatActivity.class);
                intent.putExtra("banners", mListQuangCao.get(position));
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((View) object);
    }
}
