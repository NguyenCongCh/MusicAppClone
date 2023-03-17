package com.liem.musicapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.liem.musicapp.R;
import com.liem.musicapp.adapters.ViewPagerAdapterMain;
import com.liem.musicapp.fragments.TimKiemFragment;
import com.liem.musicapp.fragments.TranngChuFragment;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        init();
    }

    public void mapping() {
        tabLayout = (TabLayout) findViewById(R.id.MainActivity_TabLayout);
        viewPager = (ViewPager) findViewById(R.id.MainActivity_ViewPager);
    }

    public void init() {
        ViewPagerAdapterMain mainViewPagerAdapter = new ViewPagerAdapterMain(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new TranngChuFragment(), "Trang chủ");
        mainViewPagerAdapter.addFragment(new TimKiemFragment(), "Tìm kiếm");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
        tabLayout.setBackgroundColor(Color.rgb(177, 177, 177));
    }
}