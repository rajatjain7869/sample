package com.example.core.di;

import com.example.core.NewsListActivity;
import com.example.core.modules.NewsModule;

import dagger.Component;

@Component(modules = NewsModule.class)
public interface CoreComponent {
    void inject(NewsListActivity newsListActivity);

}
