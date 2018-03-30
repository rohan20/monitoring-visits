package com.rohantaneja.monitoringvisits.model;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class District extends ExpandableGroup<DistrictStatisticList> {

    private int districtId;
    private String districtName;
    private DistrictStatisticList districtStatisticList;

    public District(int districtId, String districtName, DistrictStatisticList districtStatisticList) {
        super(districtName, (List<DistrictStatisticList>) districtStatisticList);
        this.districtId = districtId;
        this.districtName = districtName;
        this.districtStatisticList = districtStatisticList;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setDistrictStatisticList(DistrictStatisticList districtStatisticList) {
        this.districtStatisticList = districtStatisticList;
    }

    public int getDistrictId() {
        return districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public DistrictStatisticList getDistrictStatisticList() {
        return districtStatisticList;
    }
}
