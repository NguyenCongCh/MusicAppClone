
package com.liem.musicapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaiHat implements Parcelable{

    @SerializedName("IdBaiHat")
    @Expose
    private String idBaiHat;
    @SerializedName("IdAlbum")
    @Expose
    private String idAlbum;
    @SerializedName("IdPlayList")
    @Expose
    private String idPlaylist;
    @SerializedName("IdTheLoai")
    @Expose
    private String idTheLoai;
    @SerializedName("TenBaiHat")
    @Expose
    private String tenBaiHat;
    @SerializedName("CaSi")
    @Expose
    private String tenCaSi;
    @SerializedName("HinhBaiHat")
    @Expose
    private String hinhAnhBaiHat;
    @SerializedName("LinkBaiHat")
    @Expose
    private String linkBaiHat;

    protected BaiHat(Parcel in) {
        idBaiHat = in.readString();
        idAlbum = in.readString();
        idPlaylist = in.readString();
        idTheLoai = in.readString();
        tenBaiHat = in.readString();
        tenCaSi = in.readString();
        hinhAnhBaiHat = in.readString();
        linkBaiHat = in.readString();
    }

    public static final Creator<BaiHat> CREATOR = new Creator<BaiHat>() {
        @Override
        public BaiHat createFromParcel(Parcel in) {
            return new BaiHat(in);
        }

        @Override
        public BaiHat[] newArray(int size) {
            return new BaiHat[size];
        }
    };



    public void setIdBaiHat(String idBaiHat) {
        this.idBaiHat = idBaiHat;
    }

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(String idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getTenCaSi() {
        return tenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    public String getHinhAnhBaiHat() {
        return hinhAnhBaiHat;
    }

    public void setHinhAnhBaiHat(String hinhAnhBaiHat) {
        this.hinhAnhBaiHat = hinhAnhBaiHat;
    }

    public String getLinkBaiHat() {
        return linkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
        this.linkBaiHat = linkBaiHat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idBaiHat);
        dest.writeString(idAlbum);
        dest.writeString(idPlaylist);
        dest.writeString(idTheLoai);
        dest.writeString(tenBaiHat);
        dest.writeString(tenCaSi);
        dest.writeString(hinhAnhBaiHat);
        dest.writeString(linkBaiHat);
    }

    @Override
    public String toString() {
        return "BaiHat{" +
                "idBaiHat='" + idBaiHat + '\'' +
                ", idAlbum='" + idAlbum + '\'' +
                ", idPlaylist='" + idPlaylist + '\'' +
                ", idTheLoai='" + idTheLoai + '\'' +
                ", tenBaiHat='" + tenBaiHat + '\'' +
                ", tenCaSi='" + tenCaSi + '\'' +
                ", hinhAnhBaiHat='" + hinhAnhBaiHat + '\'' +
                ", linkBaiHat='" + linkBaiHat + '\'' +
                '}';
    }
}