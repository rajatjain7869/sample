package com.example.retrofitapihit.service;

import com.example.retrofitapihit.model.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {
    @GET("/v2/everything?q=bitcoin&from=2019-02-13&sortBy=publishedAt&apiKey=8a443e56dc04491eaaa9afc15f0648c0")
    Call<NewsList> getNewsList();
}
