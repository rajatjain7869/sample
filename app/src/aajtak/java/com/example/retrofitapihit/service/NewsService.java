package com.example.retrofitapihit.service;

import com.example.retrofitapihit.model.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {
    @GET("bins/1bsqcn/")
    Call<NewsList> getNewsList();
}
