package com.example.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.core.application.BaseApplication;
import com.example.core.application.BaseNews;
import com.example.core.databinding.SingleRowViewBinding;
import com.example.core.di.CoreComponent;
import com.example.core.di.DaggerCoreComponent;
import com.example.core.modules.NewsModule;
import com.example.core.network.IDataListener;
import com.example.core.viewmodel.NewsListViewModel;
import com.example.core.viewmodel.NewsViewModel;

import java.util.List;

import javax.inject.Inject;

public class NewsListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;
    private SingleRowViewBinding binding;

    @Inject
    BaseNews baseNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CoreComponent coreComponent = DaggerCoreComponent.builder().baseNewsModule(new NewsModule(BaseApplication.getInstance().getApi())).build();
        coreComponent.inject(this);
        baseNews.provideFactory().getNewsList(new IDataListener<NewsListViewModel>() {
            @Override
            public void onSuccess(NewsListViewModel o) {
                generateNoticeList(o.getModels());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("News", "Failure");
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
