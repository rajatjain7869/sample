package com.example.retrofitapihit.service;

import com.example.core.network.IDataListener;
import com.example.core.network.INewsSevice;
import com.example.core.viewmodel.NewsListViewModel;
import com.example.retrofitapihit.AajTakApplication;
import com.example.retrofitapihit.mapper.NewsMapper;
import com.example.retrofitapihit.model.NewsList;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
@Module
public class NewsApiService implements INewsSevice {

    @Override
    @Provides
    public void getNewsList(final IDataListener listener) {
        AajTakApplication.getInstance().getService()
                .create(NewsService.class).getNewsList().enqueue(new Callback<NewsList>() {
            @Override
            @Provides
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
