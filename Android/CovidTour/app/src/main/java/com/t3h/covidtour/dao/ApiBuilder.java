package com.t3h.covidtour.dao;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class ApiBuilder {
    private static Api builder;

    public static Api getInstance() {
        if (builder == null) {
            builder = new Retrofit.Builder()
                    .baseUrl("http://192.168.254.58:80/covid-tour/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()
                    .create(Api.class);
        }
        return builder;
    }
}
