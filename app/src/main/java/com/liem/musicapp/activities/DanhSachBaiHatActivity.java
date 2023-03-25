package com.liem.musicapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.liem.musicapp.R;
import com.liem.musicapp.adapters.RecyclerAdapterDanhSachBaiHat;
import com.liem.musicapp.models.Album;
import com.liem.musicapp.models.BaiHat;
import com.liem.musicapp.models.Playlist;
import com.liem.musicapp.models.QuangCao;
import com.liem.musicapp.models.TheLoai;
import com.liem.musicapp.services.ApiService;
import com.liem.musicapp.services.DataService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class DanhSachBaiHatActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    ImageView imgDanhSachBaiHat;

    QuangCao quangCao;
    Album album;
    Playlist playlist;
    TheLoai theLoai;

    ArrayList<BaiHat> baiHatArrayList;
    RecyclerAdapterDanhSachBaiHat recyclerAdapterDanhSachBaiHat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat);

        getData();
        mapping();
        init();

        if (quangCao != null && quangCao.getIdBaiHat() != null) {
            getValuesInView(quangCao.getTenBaiHat(), quangCao.getHinhAnhBaiHat());
            getDataQuangCao(quangCao.getIdBaiHat());
        } else if (album != null && album.getIdAlbum() != null) {
            getValuesInView(album.getTenAlbum(), album.getHinhAnhAlbum());
            getDataAlbum(album.getIdAlbum());
        } else if (playlist != null && playlist.getIdPlaylist() != null) {
            getValuesInView(playlist.getTen(), playlist.getHinhIcon());
            getDataPlaylist(playlist.getIdPlaylist());
        } else if (theLoai != null && theLoai.getIdTheLoai() != null) {
            getValuesInView(theLoai.getTenTheLoai(), theLoai.getHinhTheLoai());
            getDataTheLoai(theLoai.getIdTheLoai());
        }

    }

    private void getDataAlbum(String idAlbum) {
        DataService dataService = ApiService.getService();
        Call<List<BaiHat>> callback = dataService.getBaiHatTheoIdAlbum(idAlbum);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                baiHatArrayList = (ArrayList<BaiHat>) response.body();
                recyclerAdapterDanhSachBaiHat = new RecyclerAdapterDanhSachBaiHat(DanhSachBaiHatActivity.this, baiHatArrayList);
                recyclerView.setAdapter(recyclerAdapterDanhSachBaiHat);
                recyclerView.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {
                Log.d("tag", "Load data danhsachbaihat fail");
            }
        });
    }

    private void getDataPlaylist(String idPlaylist) {
        DataService dataService = ApiService.getService();
        Call<List<BaiHat>> callback = dataService.getBaiHatTheoIdPlaylist(idPlaylist);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                baiHatArrayList = (ArrayList<BaiHat>) response.body();
                recyclerAdapterDanhSachBaiHat = new RecyclerAdapterDanhSachBaiHat(DanhSachBaiHatActivity.this, baiHatArrayList);
                recyclerView.setAdapter(recyclerAdapterDanhSachBaiHat);
                recyclerView.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {
                Log.d("tag", "Load data danhsachbaihat fail");
            }
        });
    }

    private void getDataTheLoai(String idTheLoai) {
        DataService dataService = ApiService.getService();
        Call<List<BaiHat>> callback = dataService.getBaiHatTheoIdTheLoai(idTheLoai);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                baiHatArrayList = (ArrayList<BaiHat>) response.body();
                recyclerAdapterDanhSachBaiHat = new RecyclerAdapterDanhSachBaiHat(DanhSachBaiHatActivity.this, baiHatArrayList);
                recyclerView.setAdapter(recyclerAdapterDanhSachBaiHat);
                recyclerView.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {
                Log.d("tag", "Load data danhsachbaihat fail");
            }
        });
    }

    private void getDataQuangCao(String idBaiHat) {
        DataService dataService = ApiService.getService();
        Call<List<BaiHat>> callback = dataService.getBaiHatTheoId(idBaiHat);
        callback.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                baiHatArrayList = (ArrayList<BaiHat>) response.body();
                recyclerAdapterDanhSachBaiHat = new RecyclerAdapterDanhSachBaiHat(DanhSachBaiHatActivity.this, baiHatArrayList);
                recyclerView.setAdapter(recyclerAdapterDanhSachBaiHat);
                recyclerView.setLayoutManager(new LinearLayoutManager(DanhSachBaiHatActivity.this));
            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {
                Log.d("tag", "Load data danhsachbaihat fail");
            }
        });
    }

    private void getValuesInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {

            //fix bug android.os.NetworkOnMainThreadException
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.get().load(hinh).into(imgDanhSachBaiHat);
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_left_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleTextColor(ColorStateList.valueOf(Color.WHITE));
        collapsingToolbarLayout.setCollapsedTitleTextColor(ColorStateList.valueOf(Color.WHITE));
    }

    private void mapping() {
        coordinatorLayout = findViewById(R.id.activityDanhsachbaihat_coordinatorLayout);
        collapsingToolbarLayout = findViewById(R.id.activityDanhsachbaihat_collapsingtoolbar);
        toolbar = findViewById(R.id.activityDanhsachbaihat_toolbar);
        recyclerView = findViewById(R.id.activityDanhsachbaihat_recyclerView);
        floatingActionButton = findViewById(R.id.activityDanhsachbaihat_floatingButton);
        imgDanhSachBaiHat = findViewById(R.id.activityDanhsachbaihat_imgDanhSachCaKhuc);
    }

    private void getData() {
        Intent intent = getIntent();
        if (intent.hasExtra("banners")) {
            quangCao = (QuangCao) intent.getSerializableExtra("banners");
        } else if (intent.hasExtra("album")) {
            album = (Album) intent.getSerializableExtra("album");
        } else if (intent.hasExtra("theLoai")) {
            theLoai = (TheLoai) intent.getSerializableExtra("theLoai");
        } else if (intent.hasExtra("playlist")) {
            playlist = (Playlist) intent.getSerializableExtra("playlist");
        }
    }
}