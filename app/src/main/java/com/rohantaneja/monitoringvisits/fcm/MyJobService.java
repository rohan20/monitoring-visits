package com.rohantaneja.monitoringvisits.fcm;

import android.app.job.JobParameters;
import android.app.job.JobService;

/**
 * Created by rohantaneja on 31/03/18.
 */

public class MyJobService extends JobService {

    public static final String PUSH_ACTION_STRING = "com.fcm.msg";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

}
