package com.example.newsapp.rests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if(retrofit==null){


        retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
    return retrofit ;
    }
}
