package com.t3h.buoi7.api;

import com.t3h.buoi7.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("everything")
    Call<NewsResponse> getNews(
           @Query("q") String q,
           @Query("apiKey") String apiKey
    );
}
