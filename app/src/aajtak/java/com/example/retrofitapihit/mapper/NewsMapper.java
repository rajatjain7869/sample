package com.example.retrofitapihit.mapper;

import android.text.TextUtils;

import com.example.core.network.IMapper;
import com.example.core.viewmodel.NewsListViewModel;
import com.example.core.viewmodel.NewsViewModel;
import com.example.retrofitapihit.model.News;
import com.example.retrofitapihit.model.NewsList;

public class NewsMapper implements IMapper<NewsList, NewsListViewModel> {

    @Override
    public NewsListViewModel convertModelToViewMOdel(NewsList newsList) {

        NewsListViewModel viewModel = new NewsListViewModel();

        if(null != newsList && !newsList.getNewsList().isEmpty()) {
            for(News news : newsList.getNewsList()) {
                NewsViewModel vm = new NewsViewModel();
                vm.setTitle(TextUtils.isEmpty(news.getTitle()) ? "" : news.getTitle());
                vm.setDescriptionUrl(news.getDescription());
                vm.setImageUrl(news.getUrlToImage());
                vm.setDate("12-12-2012");
                vm.setViewCount("150");
                viewModel.setModel(vm);
            }
        }
        return viewModel;
    }
}
