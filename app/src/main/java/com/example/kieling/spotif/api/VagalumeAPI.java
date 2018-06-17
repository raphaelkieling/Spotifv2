package com.example.kieling.spotif.api;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VagalumeAPI {
    public static String url = "https://api.vagalume.com.br/";
    public VagalumeService createService(){
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        VagalumeService service = retrofit.create(VagalumeService.class);

        return service;
    }
}
