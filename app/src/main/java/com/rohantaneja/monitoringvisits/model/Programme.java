package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "programmes")
public class Programme {

    @PrimaryKey
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
