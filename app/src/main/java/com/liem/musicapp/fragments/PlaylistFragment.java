package com.liem.musicapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liem.musicapp.R;
import com.liem.musicapp.adapters.RecyclerAdapterPlaylist;
import com.liem.musicapp.models.Playlist;
import com.liem.musicapp.services.ApiService;
import com.liem.musicapp.services.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlaylistFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RecyclerAdapterPlaylist playlistRecyclerAdapter;
    private ArrayList<Playlist> playlists;

    public PlaylistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        mapping();
        getData();
        return view;
    }

    private void mapping() {
        recyclerView = view.findViewById(R.id.fmPlaylist_recyclerView);
    }

    private void getData(){
        DataService dataService = ApiService.getService();
        Call<List<Playlist>> callback = dataService.getPlaylist();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                 playlists = (ArrayList<Playlist>) response.body();
                 playlistRecyclerAdapter = new RecyclerAdapterPlaylist(getActivity(), playlists, recyclerView);
                 recyclerView.setAdapter(playlistRecyclerAdapter);
                 recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {
                Log.d("tag", "Load data playlist fail");
            }
        });
    }

}