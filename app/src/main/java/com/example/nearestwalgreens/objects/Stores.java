package com.example.nearestwalgreens.objects;


/*
*
* Base POJO class for Walgreens Stores[]
* */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Stores {

    public Stores(List<Store> stores, String next, String srchSt) {
        this.stores = stores;
        this.next = next;
        this.srchSt = srchSt;
    }

    //Array of all store objects
    @SerializedName("stores")
    public List<Store> stores;
    //"10 MORE STORES AVAILABLE INDICATOR",
    @SerializedName("next")
    public String next;
    //"STORE STATUS"
    @SerializedName("srchSt")
    public String srchSt;

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getSrchSt() {
        return srchSt;
    }

    public void setSrchSt(String srchSt) {
        this.srchSt = srchSt;
    }
}
