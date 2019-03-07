package com.example.retrofitapihit.di;

import android.app.Application;

import com.example.core.application.BaseApplication;
import com.example.retrofitapihit.service.NewsApiService;


import dagger.Component;

@Component(dependencies = {BaseApplication.class},modules = NewsApiService.class)
public interface ApplicationComponent  {
       void inject(BaseApplication baseApplication);


}
