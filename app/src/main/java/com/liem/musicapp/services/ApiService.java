package com.liem.musicapp.services;

public class ApiService {
    private static  String  base_url = "https://tranhieuserver.000webhostapp.com/Server/";

    public static DataService getService(){
        return ApiRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
