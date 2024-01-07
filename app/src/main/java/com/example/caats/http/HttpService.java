package com.example.caats.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HttpService {
    @GET("/cat")
    Call<ResponseBody> getImageUrl();

    @GET("/cat/{tag}")
    Call<ResponseBody> getImageTag(@Path("tag") String tag);

    @GET("/cat/says/{text}")
    Call<ResponseBody> getImageWithText(@Path("text") String text);
}
