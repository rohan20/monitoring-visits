package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "visits",
        foreignKeys = @ForeignKey(
                entity = Task.class,
                parentColumns = {"id"},
                childColumns = {"taskId"}))
public class Visit {

    @PrimaryKey
    @SerializedName("vid")
    private int id;
    private String clientId;
    private int taskId;
    @SerializedName("remarkOfficer")
    private String officerRemark;
    @SerializedName("remarkAdmin")
    private String adminRemark;
    private Double lat;
    private Double longitude;
    @Embedded
    @SerializedName("actionId")
    private VisitAction action;
    @Ignore
    @SerializedName("tid")
    private Task task;

    private boolean isSynced;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public boolean isSynced() {
        return isSynced;
    }

    public void setSynced(boolean synced) {
        isSynced = synced;
    }

    public void createClientId(){
        if(this.clientId == null){
            this.clientId = UUID.randomUUID().toString();
        }
    }

    public String getOfficerRemark() {
        return officerRemark;
    }

    public void setOfficerRemark(String officerRemark) {
        this.officerRemark = officerRemark;
    }

    public String getAdminRemark() {
        return adminRemark;
    }

    public void setAdminRemark(String adminRemark) {
        this.adminRemark = adminRemark;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public VisitAction getAction() {
        return action;
    }

    public void setAction(VisitAction action) {
        this.action = action;
    }

    public static class VisitAction {

        private int actionId;
        private String action;

        public int getActionId() {
            return actionId;
        }

        public void setActionId(int actionId) {
            this.actionId = actionId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }
}
