package com.example.core.adapter;


import com.example.core.binding.ItemBinder;

import java.util.List;

import javax.annotation.Nullable;

public class BaseAdapter<T> extends BindingRecyclerAdapter<T> {

    public BaseAdapter(ItemBinder<T> itemBinder, @Nullable List<T> items) {
        super(itemBinder, items);
    }


}

