package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "visits",
        foreignKeys = @ForeignKey(
                entity = Task.class,
                parentColumns = {"id"},
                childColumns = {"taskId"}))
public class Visit {

    private int id;
    private int taskId;
    private String action;

}
