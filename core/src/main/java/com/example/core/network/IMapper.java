package com.example.core.network;

public interface IMapper<I,V> {

    public V convertModelToViewMOdel(I i);
}
