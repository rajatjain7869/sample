package com.example.retrofitapihit.service;

import com.example.retrofitapihit.model.NewsDataList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {
    @GET("/api/unknowns")
    Call<NewsDataList> getNewsLists();
}
