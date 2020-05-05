package com.example.adminpanel;

public class Photo {
    public String mLocation;

    public String mImageUrl;

    public String mDescription;

    public Double mLatitude;

    public Double mLongitude;

    public String mPastImageUrl;

    public String mRecentImageUrl;

    public String mARMap;

    public Photo() {
    }

    public Photo(String mLocation, String mDescription, String mLatitude, String mLongitude,String mImageUrl,String mPastImageUrl,String mRecentImageUrl,String aRMap) {
        this.mLocation = mLocation;
        this.mDescription = mDescription;
        this.mLatitude = Double.parseDouble(mLatitude);
        this.mLongitude = Double.parseDouble(mLongitude);
        this.mPastImageUrl = mPastImageUrl;
        this.mRecentImageUrl = mRecentImageUrl;
        this.mARMap = aRMap;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmImageUrl() { return mImageUrl; }

    public void setmImageUrl(String mImageUrl) { this.mImageUrl = mImageUrl; }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(Double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public Double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(Double mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getmPastImageUrl() {

        return mPastImageUrl;
    }

    public void setmPastImageUrl(String mPastImageUrl) {

        this.mPastImageUrl = mPastImageUrl;
    }

    public String getmRecentImageUrl() {

        return mRecentImageUrl;
    }

    public void setmRecentImageUrl(String mRecentImageUrl) {
        this.mRecentImageUrl = mRecentImageUrl;
    }

    public String getmARMap() {
        return mARMap;
    }

    public void setmARMap(String mARMap) {
        this.mARMap = mARMap;
    }
}

