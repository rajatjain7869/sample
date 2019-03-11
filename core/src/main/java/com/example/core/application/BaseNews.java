package com.example.core.application;


import com.example.core.network.INewsSevice;

import javax.inject.Inject;

public class BaseNews {
    private INewsSevice iNewsSevice;

    @Inject
    public BaseNews(INewsSevice iNewsSevice) {
        this.iNewsSevice = iNewsSevice;

    }

    public INewsSevice provideFactory() {
        return iNewsSevice;
    }


}
