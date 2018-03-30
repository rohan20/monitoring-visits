package com.rohantaneja.monitoringvisits.model;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class District {

    private int districtId;
    private String districtName;
    private int numberOfTasksAssigned;
    private int numberOfTasksCompleted;
    private int numberOfVisitsMade;

    public District(int districtId, String districtName, int numberOfTasksAssigned, int numberOfTasksCompleted, int numberOfVisitsMade) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.numberOfTasksAssigned = numberOfTasksAssigned;
        this.numberOfTasksCompleted = numberOfTasksCompleted;
        this.numberOfVisitsMade = numberOfVisitsMade;
    }

    public int getDistrictId() {
        return districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public int getNumberOfTasksAssigned() {
        return numberOfTasksAssigned;
    }

    public int getNumberOfTasksCompleted() {
        return numberOfTasksCompleted;
    }

    public int getNumberOfVisitsMade() {
        return numberOfVisitsMade;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setNumberOfTasksAssigned(int numberOfTasksAssigned) {
        this.numberOfTasksAssigned = numberOfTasksAssigned;
    }

    public void setNumberOfTasksCompleted(int numberOfTasksCompleted) {
        this.numberOfTasksCompleted = numberOfTasksCompleted;
    }

    public void setNumberOfVisitsMade(int numberOfVisitsMade) {
        this.numberOfVisitsMade = numberOfVisitsMade;
    }
}
