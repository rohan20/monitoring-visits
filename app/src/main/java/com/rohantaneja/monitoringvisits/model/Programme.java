package com.rohantaneja.monitoringvisits.model;

import android.arch.persistence.room.Entity;

/**
 * Created by ralph on 30/03/18.
 */

@Entity(tableName = "programmes")
public class Programme {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
