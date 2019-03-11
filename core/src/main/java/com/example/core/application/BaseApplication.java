package com.example.core.application;

import android.app.Application;

import com.example.core.network.INewsSevice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseApplication extends Application {
    private static INewsSevice apiService;
    private Retrofit retrofit;
    private static BaseApplication instance;

    public INewsSevice getApi() {
        return apiService;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = initFactory();


    }

    public abstract String getBaseUrl();

    public Retrofit getService() {
        return retrofit;
    }

    public static BaseApplication getInstance(){
        return instance;
    }
    public abstract INewsSevice initFactory();


}
