package com.example.core.modules;

import com.example.core.network.INewsSevice;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsModule {
    INewsSevice apiService;

    public NewsModule(INewsSevice apiService) {
        this.apiService = apiService;
    }

    @Provides
    INewsSevice provideInstance() {
        return apiService;
    }
}
