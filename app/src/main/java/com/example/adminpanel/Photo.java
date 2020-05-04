package com.example.adminpanel;

public class Photo {
    public String mLocation;

    public String mImageUrl;

    public String mDescription;

    public Double mLatitude;

    public Double mLongitude;

    public Photo() {
    }

    public Photo(String mLocation, String mDescription, String mLatitude, String mLongitude) {
        this.mLocation = mLocation;
        this.mDescription = mDescription;
        this.mLatitude = Double.parseDouble(mLatitude);
        this.mLongitude = Double.parseDouble(mLongitude);
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    //public String getmImageUrl() {
    //    return mImageUrl;
    //}

   // public void setmImageUrl(String mImageUrl) {
   //     this.mImageUrl = mImageUrl;
    //}

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
}

