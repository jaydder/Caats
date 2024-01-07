package com.example.caats.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static final String BASE_URL = "https://cataas.com/";

    public HttpService RetrofitCLient() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HttpService httpService = retrofit.create(HttpService.class);

        return httpService;
    }
}
