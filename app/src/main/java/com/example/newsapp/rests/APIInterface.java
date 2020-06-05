package com.example.newsapp.rests;

import com.example.newsapp.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("top-headlines")
    Call<ResponseModel> getLatestNews(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);

    @GET("top-headlines")
    Call<ResponseModel> getSearchResults(@Query("country") String counrty, @Query("q") String q, @Query("apiKey") String apiKey);
}
