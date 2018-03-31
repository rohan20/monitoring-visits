package com.rohantaneja.monitoringvisits.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.adapter.VisitQuestionsAdapter;
import com.rohantaneja.monitoringvisits.model.Question;

import java.util.ArrayList;
import java.util.List;

public class VisitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        //TODO ask for location -> show empty view if no location, else show fields to add visit
        //TODO buttons to start questionnaire or cancel visit
        //TODO programmatically display ques
        //TODO check for internet while saving, if no internet, save to local

        List<Question> questionList = new ArrayList<>();

        RecyclerView questionsRecyclerView = findViewById(R.id.questions_recycler_view);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        VisitQuestionsAdapter adapter = new VisitQuestionsAdapter(questionList, this);
        questionsRecyclerView.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.no_location_button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                LocationManager locationManager = (LocationManager)
                        getSystemService(Context.LOCATION_SERVICE);
                if (ActivityCompat.checkSelfPermission(VisitActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(VisitActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER, 5000, 10, new LocationListener() {
                            @Override
                            public void onLocationChanged(Location loc) {
                                TextView tv = (TextView) findViewById(R.id.no_location_text_view);
                                tv.setText("Latitude: " + loc.getLatitude() + "\n Longitude: " + loc.getLongitude());
                            }

                            @Override
                            public void onStatusChanged(String provider, int status, Bundle extras) {

                            }

                            @Override
                            public void onProviderEnabled(String provider) {

                            }

                            @Override
                            public void onProviderDisabled(String provider) {

                            }
                        });

            }


        });
    }

    public void startVisit(View view) {
//        Intent i = new Intent(this, QuestionnaireActivity.class);
//        startActivity(i);
    }

//    private List<Question> prepareData() {
//        List<Question> questionList = new ArrayList<>();
//
//        List<String> optionsList = new ArrayList<>();
//        optionsList.add("A");
//        optionsList.add("B");
//        optionsList.add("C");
//        optionsList.add("D");
//
//        List<String> optionsList2 = new ArrayList<>();
//        optionsList2.add("A");
//        optionsList2.add("C");
//
//        questionList.add(new Question(1, "Water quality?", true, "Door to Door", 45, "radio button", optionsList));
//        questionList.add(new Question(2, "Water quality??", false, "Door to Door", 123, "check box", optionsList));
//        questionList.add(new Question(3, "Water quality???", true, "Door to Door", 23, "radio button", optionsList2));
//        questionList.add(new Question(3, "Water quality???", true, "Door to Door", 23, "radio button", optionsList2));
//        questionList.add(new Question(3, "Water quality???", true, "Door to Door", 23, "radio button", optionsList2));
//        questionList.add(new Question(3, "Water quality???", true, "Door to Door", 23, "radio button", optionsList2));
//
//        return questionList;
//    }
}



