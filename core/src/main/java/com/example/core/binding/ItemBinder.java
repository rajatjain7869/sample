package com.example.core.binding;

public interface ItemBinder<T> {
    int getLayoutRes(T model);

    int getBindingVariable(T model);
}
