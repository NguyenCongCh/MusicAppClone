package com.liem.musicapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liem.musicapp.R;
import com.liem.musicapp.activities.DanhSachBaiHatActivity;
import com.liem.musicapp.adapters.RecyclerAdapterBaiHatNgauNhien;
import com.liem.musicapp.adapters.RecyclerAdapterDanhSachBaiHat;
import com.liem.musicapp.models.BaiHat;
import com.liem.musicapp.services.ApiService;
import com.liem.musicapp.services.DataService;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimKiemFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private TextView txtKoCoDuLieu;

    private ArrayList<BaiHat> baiHatArrayList;
    RecyclerAdapterBaiHatNgauNhien adapter;

    public TimKiemFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tim_kiem, container, false);
        mapping();
        init();
        return view;
    }

    private void init() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_view, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getListBaiHatTimKiem(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getListBaiHatTimKiem(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void getListBaiHatTimKiem(String keyword) {
        if ( baiHatArrayList != null) {
            baiHatArrayList.clear();
            recyclerView.setAdapter(null);
        }
        DataService dataService = ApiService.getService();
        Call<List<BaiHat>> callback = dataService.getBaiHatTheoKeyword(keyword);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                baiHatArrayList = (ArrayList<BaiHat>) response.body();
                if (baiHatArrayList.size() > 0) {
                    adapter = new RecyclerAdapterBaiHatNgauNhien(getActivity(), baiHatArrayList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    txtKoCoDuLieu.setText("");
                }
                else{
                    txtKoCoDuLieu.setText("Không tìm thấy bài hát");
                }
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {
                Log.d("tag", "Load data baihat fail");
            }
        });
    }

    private void mapping() {
        toolbar = view.findViewById(R.id.fmTimKiem_toolbar);
        recyclerView = view.findViewById(R.id.fmTimKiem_recyclerView);
        txtKoCoDuLieu = view.findViewById(R.id.fmTimKiem_txtKhongCoDuLieu);
    }
}