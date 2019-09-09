package com.example.nearestwalgreens.objects;


/*
*
* Base Object for our Walgreens Search request body....
* ** Remember that Retrofit uses GSON by default, so our Java objects get converted to JSON automatically!
*
* Values we need
*   apiKey	required	The API Key that you have been approved for. Can be found here.
    affId	required	The AffiliateID that you was given in your application email.
    lat	    required	The lat value is the latitude of point your are trying to locate stores.
    lng	    required	The lng value is the longitude of point your are trying to locate stores.
*
* */
public class RequestBody {
    static final String apiKey = "K5fOylnwh1X6jm8tu1Q9AuUOKkUpXojl";
    static final String affId = "storesapi";
    String lat;
    String lng;

    public RequestBody(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
