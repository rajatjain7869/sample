package com.example.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.core.application.BaseApplication;
import com.example.core.application.BaseNews;
import com.example.core.di.CoreComponent;
import com.example.core.di.DaggerCoreComponent;
import com.example.core.modules.NewsModule;
import com.example.core.network.IDataListener;
import com.example.core.viewmodel.NewsListViewModel;
import com.example.core.viewmodel.NewsViewModel;

import java.util.List;

import javax.inject.Inject;

public class NewsListActivity extends AppCompatActivity {

    @Inject
    BaseNews baseNews;
    private NewsAdapter adapter;
    //    @Inject BaseApplication baseApplication;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CoreComponent coreComponent = DaggerCoreComponent.builder().
                newsModule(new NewsModule(BaseApplication.getInstance().getApi())).build();
        coreComponent.inject(this);
//        BaseComponent baseComponent=DaggerBaseCompon
        //ap.inject(this);
        //DaggerApplicationComponent.builder().application(this).build().inject(this);

        baseNews.provideFactory().getNewsList(new IDataListener<NewsListViewModel>() {
            @Override
            public void onSuccess(NewsListViewModel listViewModel) {
                generateNoticeList(listViewModel.getModels());
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(NewsListActivity.this, "Something went wrong...Error message: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void generateNoticeList(List<NewsViewModel> models) {

        recyclerView = findViewById(R.id.recycler_view_notice_list);
        adapter = new NewsAdapter(models);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NewsListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
