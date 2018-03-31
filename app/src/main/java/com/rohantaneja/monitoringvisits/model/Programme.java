package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "programmes")
public class Programme {

    @PrimaryKey
    private int programmeId;
    private String name;

    public int getProgrammeId() {
        return programmeId;
    }

    public String getName() {
        return name;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
