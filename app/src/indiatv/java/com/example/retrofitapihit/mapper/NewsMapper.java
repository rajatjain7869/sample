package com.example.retrofitapihit.mapper;

import android.text.TextUtils;

import com.example.core.network.IMapper;
import com.example.core.viewmodel.NewsListViewModel;
import com.example.core.viewmodel.NewsViewModel;
import com.example.retrofitapihit.model.News;
import com.example.retrofitapihit.model.NewsDataList;

public class NewsMapper implements IMapper<NewsDataList, NewsListViewModel> {
    @Override
    public NewsListViewModel convertModelToViewMOdel(NewsDataList iNewsDataList) {
        NewsListViewModel newsListViewModel = new NewsListViewModel();
        if(iNewsDataList!=null && !iNewsDataList.getiNewsArrayList().isEmpty()){
            for(News news : iNewsDataList.getiNewsArrayList()){
                NewsViewModel newsViewModel = new NewsViewModel();
                newsViewModel.setTitle(TextUtils.isEmpty(news.getName())?"":news.getName());
                newsViewModel.setDescriptionUrl(news.getColor());
                newsViewModel.setImage(String.valueOf(news.getYear()));
                newsViewModel.setDate("10-12-2019");
                newsViewModel.setViewCount("32");
                newsListViewModel.setModel(newsViewModel);
            }
        }
        return newsListViewModel;
    }
}
