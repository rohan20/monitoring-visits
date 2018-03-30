package com.rohantaneja.monitoringvisits.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;

public class VisitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        //TODO ask for location -> show empty view if no location, else show fields to add visit
        //TODO buttons to start questionnaire or cancel visit
        //TODO programmatically display ques
        //TODO check for internet while saving, if no internet, save to local
    }


}
