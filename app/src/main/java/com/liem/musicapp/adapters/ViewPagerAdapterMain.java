package com.liem.musicapp.adapters;



import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapterMain extends FragmentPagerAdapter {

    private ArrayList<Fragment> mListFragment = new ArrayList<>();
    private ArrayList<String> mListTitle = new ArrayList<>();

    public ViewPagerAdapterMain(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment.size();
    }

    public void addFragment(Fragment fragment, String title){
        mListFragment.add(fragment);
        mListTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitle.get(position);
    }
}
