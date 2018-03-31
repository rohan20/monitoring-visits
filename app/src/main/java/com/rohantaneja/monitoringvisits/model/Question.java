package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "questions",
        foreignKeys = @ForeignKey(entity = Programme.class,
        parentColumns = {"programmeId"},childColumns = {"programmeId"}))
public class Question {

    @PrimaryKey
    @SerializedName("qid")
    private int id;
    @SerializedName("question")
    private String title;
    private String description;
    private boolean required;
    private String visitType;
    private int programmeId;
    @Ignore
    @SerializedName("pid")
    private Programme programme;
    private String format;
    @Ignore
    private List<QuestionOption> options;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public Question() {
    }

    public Question(int id, String title, boolean required, String visitType, int programmeId, String format, List<QuestionOption> options) {
        this.id = id;
        this.title = title;
        this.required = required;
        this.visitType = visitType;
        this.programmeId = programmeId;
        this.format = format;
        this.options = options;
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

    public List<QuestionOption> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOption> options) {
        this.options = options;
    }
}
