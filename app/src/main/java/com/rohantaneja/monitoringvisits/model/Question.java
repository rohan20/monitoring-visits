package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "questions",
        foreignKeys = @ForeignKey(entity = Programme.class,
        parentColumns = {"programmeId"},childColumns = {"programmeId"}))
public class Question {

    @PrimaryKey
    private int id;
    private String title;
    private boolean required;
    private String visitType;
    private int programmeId;
    private String format;
    @Ignore
    private List<String> options;

    public Question() {
    }

    public Question(int id, String title, boolean required, String visitType, int programmeId, String format, List<String> options) {
        this.id = id;
        this.title = title;
        this.required = required;
        this.visitType = visitType;
        this.programmeId = programmeId;
        this.format = format;
        this.options = options;
    }
    private String questionType;

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
