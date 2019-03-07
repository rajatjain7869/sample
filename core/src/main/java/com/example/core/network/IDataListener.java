package com.example.core.network;

public interface IDataListener<T> {

    public void onSuccess(T t);
    public void onFailure(Throwable t);
}
