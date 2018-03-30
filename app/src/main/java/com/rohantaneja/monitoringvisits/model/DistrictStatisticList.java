package com.rohantaneja.monitoringvisits.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class DistrictStatisticList implements Parcelable {

    private List<DistrictStatistic> districtStatisticList;

    public DistrictStatisticList(List<DistrictStatistic> districtStatisticList) {
        this.districtStatisticList = districtStatisticList;
    }

    protected DistrictStatisticList(Parcel in) {
        districtStatisticList = in.createTypedArrayList(DistrictStatistic.CREATOR);
    }

    public static final Creator<DistrictStatisticList> CREATOR = new Creator<DistrictStatisticList>() {
        @Override
        public DistrictStatisticList createFromParcel(Parcel in) {
            return new DistrictStatisticList(in);
        }

        @Override
        public DistrictStatisticList[] newArray(int size) {
            return new DistrictStatisticList[size];
        }
    };

    public void setDistrictStatisticList(List<DistrictStatistic> districtStatisticList) {
        this.districtStatisticList = districtStatisticList;
    }

    public List<DistrictStatistic> getDistrictStatisticList() {
        return districtStatisticList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(districtStatisticList);
    }
}
