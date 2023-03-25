
package com.liem.musicapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuangCao implements Serializable {

    @SerializedName("IdQuangCao")
    @Expose
    private String idQuangCao;
    @SerializedName("NoiDung")
    @Expose
    private String noiDung;
    @SerializedName("HinhAnhQuangCao")
    @Expose
    private String hinhAnhQuangCao;
    @SerializedName("IdBaiHat")
    @Expose
    private String idBaiHat;
    @SerializedName("TenBaiHat")
    @Expose
    private String tenBaiHat;
    @SerializedName("HinhAnhBaiHat")
    @Expose
    private String hinhAnhBaiHat;

    public String getIdQuangCao() {
        return idQuangCao;
    }

    public void setIdQuangCao(String idQuangCao) {
        this.idQuangCao = idQuangCao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinhAnhQuangCao() {
        return hinhAnhQuangCao;
    }

    public void setHinhAnhQuangCao(String hinhAnhQuangCao) {
        this.hinhAnhQuangCao = hinhAnhQuangCao;
    }

    public String getIdBaiHat() {
        return idBaiHat;
    }

    public void setIdBaiHat(String idBaiHat) {
        this.idBaiHat = idBaiHat;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getHinhAnhBaiHat() {
        return hinhAnhBaiHat;
    }

    public void setHinhAnhBaiHat(String hinhAnhBaiHat) {
        this.hinhAnhBaiHat = hinhAnhBaiHat;
    }

}