package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ralph on 31/03/18.
 */

@Entity(tableName = "answers")
public class QuestionAnswer {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String clientId;
    private String value;
    private int questionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public QuestionAnswer(String clientId, String value, int questionId) {

        this.clientId = clientId;
        this.value = value;
        this.questionId = questionId;
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
