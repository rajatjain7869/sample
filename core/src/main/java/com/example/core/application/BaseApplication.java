package com.example.core.application;

import android.app.Application;



import com.example.core.network.INewsSevice;

import javax.inject.Inject;

import dagger.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseApplication extends Application {

    private ApplicationComponent applicationComponent;
    private static INewsSevice apiService;
    private Retrofit retrofit;
    private static BaseApplication instance;

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

    public static INewsSevice provideFactory(){
        return apiService;
    }

    public abstract INewsSevice initFactory();


}
