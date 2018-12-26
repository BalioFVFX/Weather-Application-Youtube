package com.example.network;

import io.reactivex.Observable;

public interface IData<T> {
    Observable<T> getData();
}
