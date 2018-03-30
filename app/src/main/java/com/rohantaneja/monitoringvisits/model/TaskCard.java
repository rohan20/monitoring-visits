package com.rohantaneja.monitoringvisits.model;

/**
 * Created by Shiv Kumar Aggarwal on 30-03-2018.
 */

public class TaskCard {
    String visitnum;
    String taskname;
    String orgname;
    String date;

    public TaskCard(String visitnum, String taskname, String orgname, String date) {
        this.visitnum = visitnum;
        this.taskname = taskname;
        this.orgname = orgname;
        this.date = date;
    }

    public String getVisitnum() {
        return visitnum;
    }

    public void setVisitnum(String visitnum) {
        this.visitnum = visitnum;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
