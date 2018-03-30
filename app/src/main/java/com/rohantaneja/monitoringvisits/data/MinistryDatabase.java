package com.rohantaneja.monitoringvisits.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.rohantaneja.monitoringvisits.data.dao.MinistryDAO;
import com.rohantaneja.monitoringvisits.model.Programme;
import com.rohantaneja.monitoringvisits.model.Question;
import com.rohantaneja.monitoringvisits.model.QuestionOption;
import com.rohantaneja.monitoringvisits.model.Task;
import com.rohantaneja.monitoringvisits.model.Visit;

/**
 * Created by ralph on 30/03/18.
 */

@Database(entities = {
        Programme.class,
        Question.class,
        QuestionOption.class,
        Task.class,
        Visit.class},version = 1)
public abstract class MinistryDatabase extends RoomDatabase {

    private static MinistryDatabase INSTANCE;

    public static MinistryDatabase getInstance(Context context) {
        if(INSTANCE == null){
         return Room.databaseBuilder(context.getApplicationContext(),MinistryDatabase.class,"ministry_database")
                 .allowMainThreadQueries()
                 .build() ;
        }
        return INSTANCE;
    }

    abstract MinistryDAO getMinistryDAO();


}
