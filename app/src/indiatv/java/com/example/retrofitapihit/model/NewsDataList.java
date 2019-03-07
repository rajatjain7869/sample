package com.example.retrofitapihit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsDataList {

    @SerializedName("data")
    private ArrayList<News> iNewsArrayList;
    public ArrayList<News> getiNewsArrayList() {
        return iNewsArrayList;
    }

    public void setiNewsArrayList(ArrayList<News> iNewsArrayList) {
        this.iNewsArrayList = iNewsArrayList;
    }

}
