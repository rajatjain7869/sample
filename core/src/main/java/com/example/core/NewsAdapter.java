package com.example.core;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.core.databinding.SingleRowViewBinding;
import com.example.core.viewmodel.NewsViewModel;


import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsViewModel> dataList;

    public NewsAdapter(List<NewsViewModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SingleRowViewBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.single_row_view, parent, false);
        return new NewsViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(final NewsViewHolder holder, int position) {
        holder.rowBinding.setModel(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        private SingleRowViewBinding rowBinding;

        NewsViewHolder(final SingleRowViewBinding itemBinding) {
            super(itemBinding.getRoot());
            this.rowBinding = itemBinding;
        }
    }
}
