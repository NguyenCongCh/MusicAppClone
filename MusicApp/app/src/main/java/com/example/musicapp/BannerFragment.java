package com.liem.musicapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liem.musicapp.R;
import com.liem.musicapp.adapters.ViewPagerBannerAdapter;
import com.liem.musicapp.models.QuangCao;
import com.liem.musicapp.services.ApiService;
import com.liem.musicapp.services.DataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerFragment extends Fragment {

    private View view;
    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicator;

    private ViewPagerBannerAdapter bannerAdapter;
    private int currentItem = 0;
    private Runnable runnable;

    public BannerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_banner, container, false);
        mapping();
        getData();
        return view;
    }

    private void mapping() {
        mViewPager = view.findViewById(R.id.fmBanner_viewPager);
        mCircleIndicator = view.findViewById(R.id.fmBanner_circleIndicator);
    }

    private void getData(){
        DataService dataService = ApiService.getService();
        Call<List<QuangCao>> callback = dataService.getDataBanner() ;
        callback.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                ArrayList<QuangCao> banners = (ArrayList<QuangCao>) response.body();
                bannerAdapter = new ViewPagerBannerAdapter(getActivity(), banners);
                mViewPager.setAdapter(bannerAdapter);
                mCircleIndicator.setViewPager(mViewPager);
                Log.d("BBB",banners.get(0).getTenBaiHat());
                //Auto scroll banner
                Handler handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem++;
                        if(currentItem >= mViewPager.getAdapter().getCount())
                            currentItem = 0;
                        mViewPager.setCurrentItem(currentItem);
                        handler.postDelayed(runnable, 2500);
                    }
                };
                handler.postDelayed(runnable, 4000);
            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {
                Log.d("tag", "Call list banner fail");
            }
        });
    }
}