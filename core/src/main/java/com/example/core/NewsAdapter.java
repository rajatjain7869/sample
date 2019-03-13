package com.example.core;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.core.databinding.SingleRowViewBinding;
import com.example.core.viewmodel.NewsViewModel;

import java.util.List;

public class NewsAdapter extends BaseRecyclerViewAdapter<NewsViewModel, NewsAdapter.NewsViewHolder> {
    public NewsAdapter(List items, Context context) {
        super(items, context);
        dataList = items;
    }


    private List<NewsViewModel> dataList;

//
//   // public NewsAdapter(List<NewsViewModel> dataList) {
//        this.dataList = dataList;
//    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SingleRowViewBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.single_row_view, parent, false);
        return new NewsViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        newsViewHolder.rowBinding.setModel(dataList.get(i));
    }

/*
    @Override
    public void onBindViewHolder(final NewsViewHolder holder, int position) {
        holder.rowBinding.setModel(dataList.get(position));
    }*/

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class NewsViewHolder extends BaseViewHolder {
        private SingleRowViewBinding rowBinding;

        NewsViewHolder(final SingleRowViewBinding itemBinding) {
            super(itemBinding.getRoot());
            this.rowBinding = itemBinding;
        }

    }
}
