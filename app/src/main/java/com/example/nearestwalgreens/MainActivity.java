package com.example.nearestwalgreens;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.nearestwalgreens.connections.LoadData;
import com.example.nearestwalgreens.objects.Store;
import com.example.nearestwalgreens.objects.Stores;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.security.Permissions;
import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;



/*
*
*  ~~Purpose of the application: ~~~
*
*  Use GeoLocations to grab users location
* Using the Long/Lat, send a request to the Walgreens store Locator API
* Display the nearest store locations in RecyclerView
* Enable individual location clicks to view more information about the store
*
*                       🦊🦁🦋
* */


public class MainActivity extends AppCompatActivity{

    private GoogleApiClient googleApiClient;
    static final int PERMISSION_ACCESS_COARSE_LOCATION = 101;
    static final String TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the GoogleApiClient using the builder and passing in our defined callbacks/listeners
            //Also be sure to list the 'Location API' as a service we want to get from the GoogleClient
        googleApiClient = new GoogleApiClient.Builder(this, connectionCallbacks, failedListener).addApi(LocationServices.API).build();

        //Since location service is vital for our application to work, we should immediately request permission to use them
            //Start by checking if the permission has already been granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            //If it has NOT already been granted, we can request them here 👇
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_COARSE_LOCATION },
                    PERMISSION_ACCESS_COARSE_LOCATION);
        }
    }

    //Now we should actually define our connection Callbacks for the GoogleApiClient
    GoogleApiClient.ConnectionCallbacks connectionCallbacks = new GoogleApiClient.ConnectionCallbacks() {
        @Override
        public void onConnected(@Nullable Bundle bundle) {
            //When the client is connected, we check again to make sure we have permission to access location
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Then using the FusedLocationApi from Google, we access the users location
                Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

                double lat = lastLocation.getLatitude(), lon = lastLocation.getLongitude();

                findStoreLocations(Double.toString(lat), Double.toString(lon));
            } else {
                //Seems like our user does not want us to know their location... understandable!
                Toast.makeText(MainActivity.this, "Sadly, this app will not work without location", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onConnectionSuspended(int i) {

        }
    };

    GoogleApiClient.OnConnectionFailedListener failedListener = new GoogleApiClient.OnConnectionFailedListener() {
        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            Log.e(TAG, "Unable to connect to GoogleApiServices");
        }
    };

    private void findStoreLocations(String lat, String lng) {
        //Attempt to pull nearby store locations
        LoadData loader = new LoadData();
        loader.loadData(lat, lng)
           .observeOn(AndroidSchedulers.mainThread())
           .subscribeOn(Schedulers.io())
           .subscribe(new DisposableObserver<Stores>(){

             @Override
             public void onNext(Stores stores) {
               Log.i("LOADDATA", stores.toString());
               handleResponse(stores);
             }

             @Override
             public void onError(Throwable e) {
               Log.e("LOADDATA", "Encountered an error");
               e.printStackTrace();
             }

             @Override
             public void onComplete() {
               Log.i("LOADDATA", "Load Data onComplete");
             }
        });
    }

    private void handleResponse(Stores stores){
        //TODO ~ Using the stores object, we can fill our recyclerview with Stores!

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (googleApiClient != null){
            googleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //Callback for when permissions change
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // All good!
                } else {
                    Toast.makeText(this, "Need your location!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
