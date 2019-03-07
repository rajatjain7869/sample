package com.example.retrofitapihit.service;

import com.example.core.network.IDataListener;
import com.example.core.network.INewsSevice;
import com.example.core.viewmodel.NewsListViewModel;
import com.example.retrofitapihit.IndiaTvApplication;
import com.example.retrofitapihit.mapper.NewsMapper;
import com.example.retrofitapihit.model.NewsDataList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ITVNewsService implements INewsSevice {
    @Override

    public void getNewsList(final IDataListener listener) {
        IndiaTvApplication.getInstance().getService().create(NewsService.class).getNewsLists().enqueue(new Callback<NewsDataList>() {
            @Override
            public void onResponse(Call<NewsDataList> call, Response<NewsDataList> response) {
                NewsDataList list = response.body();
                NewsListViewModel viewModel= new NewsMapper().convertModelToViewMOdel(list);
                listener.onSuccess(viewModel);
            }

            @Override
            public void onFailure(Call<NewsDataList> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}
