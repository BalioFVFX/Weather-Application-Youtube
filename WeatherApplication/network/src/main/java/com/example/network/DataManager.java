package com.example.network;

import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataManager<T> implements IData {


    private final String url;
    private final Gson gson;
    private final OkHttpClient client;
    private final Class<T> tClass;

    public DataManager(String url, Class<T> tClass){
        this.url = url;
        this.client = new OkHttpClient();
        this.gson = new Gson();
        this.tClass = tClass;
    }

    @Override
    public Observable getData() {
        return Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                Request request = new Request.Builder()
                        .url(url).build();

                Response response = client.newCall(request).execute();

                T result = mapFromJson(response.body().string(), tClass);
                emitter.onNext(result);
            }
        });
    }

    private T mapFromJson(String json, Class<T> tClass){
        return this.gson.fromJson(json, tClass);
    }
}
