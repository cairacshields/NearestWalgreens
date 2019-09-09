package com.example.nearestwalgreens.connections;

import com.example.nearestwalgreens.objects.RequestBody;
import com.example.nearestwalgreens.objects.Stores;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/*
* Retrofit Walgreens API interface
* */

public interface GetData {

    //Create a getter for base request
    @POST("stores/search")
    Observable<Stores> getData(@Body RequestBody body);
}
