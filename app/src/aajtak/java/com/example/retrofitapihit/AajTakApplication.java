package com.example.retrofitapihit;

import android.app.Application;

import com.example.core.application.BaseApplication;
import com.example.core.network.INewsSevice;
import com.example.retrofitapihit.service.NewsApiService;

public class AajTakApplication extends BaseApplication {

    @Override
    public String getBaseUrl() {
        return "https://api.myjson.com/";
    }

    @Override
    public INewsSevice initFactory() {
        return new NewsApiService();
    }
}
