package com.example.nearestwalgreens.objects;

import com.google.gson.annotations.SerializedName;

public class Store {

    @SerializedName("stnm")
    public String stnm;
    @SerializedName("stadd")
    public String stadd;
    @SerializedName("sttyp")
    public String sttyp;
    @SerializedName("stct")
    public String stct;
    @SerializedName("stst")
    public String stst;
    @SerializedName("stzp")
    public String stzp;
    @SerializedName("stdist")
    public String stdist;

    @SerializedName("storeOpenTime")
    public String storeOpenTime;
    @SerializedName("storeCloseTime")
    public String storeCloseTime;
    @SerializedName("pharmacyOpenTime")
    public String pharmacyOpenTime;
    @SerializedName("pharmacyCloseTime")
    public String pharmacyCloseTime;
    @SerializedName("clinicCloseTime")
    public String clinicCloseTime;
    @SerializedName("clinicOpenTime")
    public String clinicOpenTime;

    @SerializedName("locationName")
    public String locationName;

    public Store(String stnm, String stadd, String sttyp, String stct, String stst, String stzp, String stdist,
                 String storeOpenTime, String storeCloseTime, String pharmacyOpenTime, String pharmacyCloseTime,
                 String clinicCloseTime, String clinicOpenTime, String locationName) {
        this.stnm = stnm;
        this.stadd = stadd;
        this.sttyp = sttyp;
        this.stct = stct;
        this.stst = stst;
        this.stzp = stzp;
        this.stdist = stdist;

        this.storeOpenTime = storeOpenTime;
        this.storeCloseTime = storeCloseTime;
        this.pharmacyOpenTime = pharmacyOpenTime;
        this.pharmacyCloseTime = pharmacyCloseTime;
        this.clinicCloseTime = clinicCloseTime;
        this.clinicOpenTime = clinicOpenTime;

        this.locationName = locationName;
    }

    public String getStnm() {
        return stnm;
    }

    public void setStnm(String stnm) {
        this.stnm = stnm;
    }

    public String getStadd() {
        return stadd;
    }

    public void setStadd(String stadd) {
        this.stadd = stadd;
    }

    public String getSttyp() {
        return sttyp;
    }

    public void setSttyp(String sttyp) {
        this.sttyp = sttyp;
    }

    public String getStct() {
        return stct;
    }

    public void setStct(String stct) {
        this.stct = stct;
    }

    public String getStst() {
        return stst;
    }

    public void setStst(String stst) {
        this.stst = stst;
    }

    public String getStzp() {
        return stzp;
    }

    public void setStzp(String stzp) {
        this.stzp = stzp;
    }

    public String getStdist() {
        return stdist;
    }

    public void setStdist(String stdist) {
        this.stdist = stdist;
    }

    public String getStoreOpenTime() {
        return storeOpenTime;
    }

    public void setStoreOpenTime(String storeOpenTime) {
        this.storeOpenTime = storeOpenTime;
    }

    public String getStoreCloseTime() {
        return storeCloseTime;
    }

    public void setStoreCloseTime(String storeCloseTime) {
        this.storeCloseTime = storeCloseTime;
    }

    public String getPharmacyOpenTime() {
        return pharmacyOpenTime;
    }

    public void setPharmacyOpenTime(String pharmacyOpenTime) {
        this.pharmacyOpenTime = pharmacyOpenTime;
    }

    public String getPharmacyCloseTime() {
        return pharmacyCloseTime;
    }

    public void setPharmacyCloseTime(String pharmacyCloseTime) {
        this.pharmacyCloseTime = pharmacyCloseTime;
    }

    public String getClinicCloseTime() {
        return clinicCloseTime;
    }

    public void setClinicCloseTime(String clinicCloseTime) {
        this.clinicCloseTime = clinicCloseTime;
    }

    public String getClinicOpenTime() {
        return clinicOpenTime;
    }

    public void setClinicOpenTime(String clinicOpenTime) {
        this.clinicOpenTime = clinicOpenTime;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}


/*
*
*
* Sample Store Response model
*
* {
    "stores": [
        {
            "stnm": "STORE NUMBER",
            "stadd": "STORE ADDRESS",
            "sttyp": "STORE TYPE",
            "stct": "STORE CITY",
            "stst": "STORE STATE",
            "stzp": "STORE ZIPCODE",
            "stdist": "STORE DISTANCE",
            "stph": "STORE PHONE NUMBER",
            "stlat": "STORE LATITUDE",
            "stlng": "STORE LONGITUDE",
            "sttmz": "STORE TIMEZONE",
            "storeType": "STORE TYPE",
            "stposterInd": "STORE POSTER INDICATOR",
            "stcreativeInd": "STORE CREATIVE INDICATOR",
            "storeOpenTime": "STORE OPEN TIME",
            "storeCloseTime": "STORE CLOSE TIME",
            "pharmacyOpenTime": "PHARMACY OPEN TIME",
            "pharmacyCloseTime": "PHARMACY CLOSE TIME",
            "clinicCloseTime": "CLINIC CLOSE TIME",
            "clinicOpenTime": "CLINIC OPEN TIME",
            "holidayEvent": "HOLIDAY EVENT TODAY",
            "extendedHours": "EXTENDED HOURS INDICATOR",
            "clinicTypeInd": "CLINIC TYPE INDICATOR",
            "locationName": "STORE LOCATION NICKNAME",
            "partnerName": "STORE PARTNER NAME",
            "pharmacyExtendedHours": "PHARMACY EXTENDED HOURS INDICATOR",
            "nativeScheduler": "SUPPORTS NATIVE SCHEDULER",
            "schedulingUrl": "CLINIC SCHEDULING URL",
            "telePharmacyKiosk": "TELEPHARMACY KIOSK",
            "beaconInd": "BLOOTOOTH BEACON INDICATOR",
            "isMatchMadeEligibleStore": "BEAUTY MATCHMADE™ INDICATOR",
            "photoInd": "PHOTO STATUS INDICATOR",
            "pharmacyStatus": "PHARMACY STATUS INDICATOR",
            "clinicStatus": "CLINC STATUS INDICATOR",
            "storeStatus": "STORE STATUS INDICATOR"
        },
        "#//Repeated for TEN closest stores to customer#//"
    ],
    "next": "10 MORE STORES AVAILABLE INDICATOR",
    "srchSt": "STORE STATUS"
}
*
* */