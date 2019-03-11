package com.example.retrofitapihit.service;

import com.example.core.network.IDataListener;
import com.example.core.network.INewsSevice;
import com.example.core.viewmodel.NewsListViewModel;
import com.example.retrofitapihit.AajTakApplication;
import com.example.retrofitapihit.mapper.NewsMapper;
import com.example.retrofitapihit.model.NewsList;

import javax.inject.Inject;

import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsApiService implements INewsSevice {
    @Inject
    public NewsApiService() {

    }

    @Override

    public void getNewsList(final IDataListener listener) {
        AajTakApplication.getInstance().getService()
                .create(NewsService.class).getNewsList().enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                NewsList list = response.body();
                NewsListViewModel vm = new NewsMapper().convertModelToViewMOdel(list);
                listener.onSuccess(vm);
            }

            @Override
            @Provides
            public void onFailure(Call<NewsList> call, Throwable t) {

                listener.onFailure(t);
            }
        });
    }
}
