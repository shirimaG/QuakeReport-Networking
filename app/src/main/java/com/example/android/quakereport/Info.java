package com.example.android.quakereport;

public class Info {

    //word to hold magnitude
    private Double mMagnitude;

    //word to hold places
    private String mPlace;

    //word to hold the date
    private long mDate;

    //word to hold url
    private String mUrl;

    /**
     * Constructor to hold three Items
     *
     * @param magnitude
     * @param place
     * @param idate
     */
    Info(Double magnitude, String place, long idate, String url) {
        mMagnitude = magnitude;
        mPlace = place;
        mDate = idate;
        mUrl = url;
    }

    /**
     * method to return magnitude
     *
     * @return String
     */
    public Double getmMagnitude() {
        return mMagnitude;
    }

    /**
     * method to return a place
     *
     * @return String
     */
    public String getmPlace() {
        return mPlace;
    }

    /**
     * method to return the date
     *
     * @return String
     */
    public long getmDate() {
        return mDate;
    }

    /**
     * method to return respective url when item is clicked
     *
     * @return String url
     */
    public String getmUrl() {
        return mUrl;
    }
}
