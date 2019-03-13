package com.example.retrofitapihit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsList {

    @SerializedName("articles")
    private ArrayList<News> newsList;

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    public void setNoticeArrayList(ArrayList<News> newsArrayList) {
        this.newsList = newsArrayList;
    }
}