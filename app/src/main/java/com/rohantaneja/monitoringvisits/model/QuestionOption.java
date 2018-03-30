package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Query;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "questionOptions",
            foreignKeys = @ForeignKey(
                    entity = Question.class,
                    parentColumns = {"id"},
                    childColumns = {"questionId"}))
public class QuestionOption {

    private int id;
    private int questionId;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
