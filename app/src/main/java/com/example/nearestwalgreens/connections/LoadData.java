package com.example.nearestwalgreens.connections;

import android.util.Log;

import com.example.nearestwalgreens.objects.RequestBody;
import com.example.nearestwalgreens.objects.Stores;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.observers.DisposableLambdaObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadData {
    private static final String BASE_URL = "https://services.walgreens.com/api/";
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Stores stores;

    public Stores getStores() {
        return this.stores;
    }
    public Observable<Stores> loadData(String lat, String lng) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        GetData requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(GetData.class);

      return requestInterface.getData(new RequestBody(lat, lng));
    }

    private void handleResponse(Stores stores) {
        Log.i("HANDLER", stores.toString());
        this.stores = stores;
    }

}
