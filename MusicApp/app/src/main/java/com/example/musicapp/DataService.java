package com.liem.musicapp.services;

import com.liem.musicapp.models.Album;
import com.liem.musicapp.models.BaiHat;
import com.liem.musicapp.models.ChuDe;
import com.liem.musicapp.models.Playlist;
import com.liem.musicapp.models.QuangCao;
import com.liem.musicapp.models.TheLoai;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataService {

    @GET("bai-hat-banner.php")
    Call<List<QuangCao>> getDataBanner();

    @GET("playlist.php")
    Call<List<Playlist>> getPlaylist();

    @GET("chude.php")
    Call<List<ChuDe>> getChuDe();

    @GET("theloai.php")
    Call<List<TheLoai>> getTheLoai();

    @GET("album.php")
    Call<List<Album>> getAlbum();

    @GET("bai-hat-ngau-nhien.php")
    Call<List<BaiHat>> getBaiHatNgauNhien();

    @FormUrlEncoded
    @POST("danh-sach-bai-hat.php")
    Call<List<BaiHat>> getBaiHatTheoId(@Field("idBaiHat") String idBaiHat);

    @FormUrlEncoded
    @POST("danh-sach-bai-hat.php")
    Call<List<BaiHat>> getBaiHatTheoIdAlbum(@Field("idAlbum") String idAlbum);

    @FormUrlEncoded
    @POST("danh-sach-bai-hat.php")
    Call<List<BaiHat>> getBaiHatTheoIdTheLoai(@Field("idTheLoai") String idTheLoai);

    @FormUrlEncoded
    @POST("danh-sach-bai-hat.php")
    Call<List<BaiHat>> getBaiHatTheoIdPlaylist(@Field("idPlaylist") String idPlaylist);

    @FormUrlEncoded
    @POST("tim-bai-hat.php")
    Call<List<BaiHat>> getBaiHatTheoKeyword(@Field("keyword") String keyword);
}
