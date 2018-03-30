package com.rohantaneja.monitoringvisits.model;

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
}
