package com.rohantaneja.monitoringvisits.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rohantaneja on 30/03/18.
 */

class DistrictStatistic implements Parcelable {

    private String statisticName;
    private long statisticValue;

    public DistrictStatistic(String statisticName, long statisticValue) {
        this.statisticName = statisticName;
        this.statisticValue = statisticValue;
    }

    protected DistrictStatistic(Parcel in) {
        statisticName = in.readString();
        statisticValue = in.readLong();
    }

    public static final Creator<DistrictStatistic> CREATOR = new Creator<DistrictStatistic>() {
        @Override
        public DistrictStatistic createFromParcel(Parcel in) {
            return new DistrictStatistic(in);
        }

        @Override
        public DistrictStatistic[] newArray(int size) {
            return new DistrictStatistic[size];
        }
    };

    public void setStatisticName(String statisticName) {
        this.statisticName = statisticName;
    }

    public void setStatisticValue(long statisticValue) {
        this.statisticValue = statisticValue;
    }

    public String getStatisticName() {
        return statisticName;
    }

    public long getStatisticValue() {
        return statisticValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(statisticName);
        parcel.writeLong(statisticValue);
    }
}
