package com.liem.musicapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liem.musicapp.R;
import com.liem.musicapp.adapters.RecyclerAdapterPlayDanhSachBaiHat;
import com.liem.musicapp.models.BaiHat;

import java.util.ArrayList;


public class PlayDanhSachBaiHatFragment extends Fragment {

    private View view;
    RecyclerView recyclerView;
    private ArrayList<BaiHat> baiHatArrayList;
    private RecyclerAdapterPlayDanhSachBaiHat recyclerAdapterPlayDanhSachBaiHat;

    public PlayDanhSachBaiHatFragment(ArrayList<BaiHat> baiHatArrayList) {
        this.baiHatArrayList = baiHatArrayList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_danh_sach_bai_hat, container, false);
        recyclerView = view.findViewById(R.id.fmPlayDanhSachBaiHat_recyclerView);
        recyclerAdapterPlayDanhSachBaiHat = new RecyclerAdapterPlayDanhSachBaiHat(getActivity(), baiHatArrayList);
        recyclerView.setAdapter(recyclerAdapterPlayDanhSachBaiHat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}