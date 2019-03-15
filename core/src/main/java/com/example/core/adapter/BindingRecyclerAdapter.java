package com.example.core.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.core.binding.ItemBinder;

import java.util.List;

import javax.annotation.Nullable;

public class BindingRecyclerAdapter<T> extends RecyclerView.Adapter<BindingRecyclerAdapter.ViewHolder> {

    private final ItemBinder<T> itemBinder;
    List<T> list;
    private LayoutInflater inflater;

    public BindingRecyclerAdapter(ItemBinder<T> itemBinder, @Nullable List<T> items) {
        this.itemBinder = itemBinder;
        this.list = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int layoutId) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }

        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        final T item = list.get(position);
        viewHolder.binding.setVariable(itemBinder.getBindingVariable(item), item);
//        viewHolder.binding.getRoot().setTag(ITEM_MODEL, item);

    }

    @Override
    public int getItemViewType(int position) {
        return itemBinder.getLayoutRes(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}