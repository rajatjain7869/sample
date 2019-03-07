package com.example.retrofitapihit;

import com.example.core.application.BaseApplication;
import com.example.core.network.INewsSevice;
import com.example.retrofitapihit.service.ITVNewsService;

public class IndiaTvApplication extends BaseApplication {
    @Override
    public String getBaseUrl() {
        return "https://reqres.in";
    }

    @Override
    public INewsSevice initFactory() {
        return new ITVNewsService();
    }
}
