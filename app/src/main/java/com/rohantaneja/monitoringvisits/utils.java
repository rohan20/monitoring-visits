package com.rohantaneja.monitoringvisits;

import android.content.Context;

import com.rohantaneja.monitoringvisits.data.MinistryDatabase;
import com.rohantaneja.monitoringvisits.model.Task;
import com.rohantaneja.monitoringvisits.model.Visit;

import java.util.ArrayList;

/**
 * Created by ralph on 31/03/18.
 */

public class utils {


    public static void saveRetrofitTasks(ArrayList<Task> tasks, Context context){
        if(tasks != null){
            for(Task task:tasks){
                task.setProgrammeId(task.getProgramme().getId());
            }
            MinistryDatabase.getInstance(context).getMinistryDAO().insertTasks(tasks);
        }
    }

    public static void saveRetrofitVisits(ArrayList<Visit> visits,Context context){
        if(visits != null){
            for(Visit visit:visits){
                visit.setTaskId(visit.getTask().getId());
            }
            MinistryDatabase.getInstance(context).getMinistryDAO().insertVisits(visits);
        }
    }
}
