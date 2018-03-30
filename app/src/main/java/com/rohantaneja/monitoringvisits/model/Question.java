package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "questions",
        foreignKeys = @ForeignKey(entity = Programme.class,
        parentColumns = {"id"},childColumns = {"programmeId"}))
public class Question {

    @PrimaryKey
    private int id;
    private String title;
    private boolean required;
    private String visitType;
    private int programmeId;
    private String format;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }
}
