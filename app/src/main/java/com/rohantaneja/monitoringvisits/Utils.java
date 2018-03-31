package com.rohantaneja.monitoringvisits;

import android.content.Context;

import com.rohantaneja.monitoringvisits.data.MinistryDatabase;
import com.rohantaneja.monitoringvisits.data.dao.MinistryDAO;
import com.rohantaneja.monitoringvisits.model.Programme;
import com.rohantaneja.monitoringvisits.model.Task;
import com.rohantaneja.monitoringvisits.model.Visit;

import java.util.ArrayList;

/**
 * Created by ralph on 31/03/18.
 */

public class Utils {


    public static void saveRetrofitTasks(ArrayList<Task> tasks, Context context){
        if(tasks != null){
            MinistryDAO dao = MinistryDatabase.getInstance(context).getMinistryDAO();
            for(Task task:tasks){
                Programme programme = task.getProgramme();
                if(programme != null) {
                    dao.insertProgramme(programme);
                    task.setProgrammeId(task.getProgramme().getId());
                }
            }
            dao.insertTasks(tasks);
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
