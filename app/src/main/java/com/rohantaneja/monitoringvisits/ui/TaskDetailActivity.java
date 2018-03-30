package com.rohantaneja.monitoringvisits.ui;

/**
 * Created by Mansi sharma on 30-03-2018.
 */
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.rohantaneja.monitoringvisits.R;



import java.util.Calendar;
import java.util.Locale;
public class TaskDetailActivity extends FragmentActivity implements
    View.OnClickListener {

        TextView btnDatePicker, btnDatePicker2;
        TextView txtDate, txtDate2;
        private int mYear, mMonth, mDay, mHour, mMinute;
        Marker mCurrLocationMarker;
        GoogleMap mMap;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.taskdetailactivity);
            Button btn_click = (Button) findViewById(R.id.btn_click);
            btn_click.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            double latitude = 28.644800;
                            double longitude = 77.216721;
                            String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);


                            Uri gmmIntentUri = Uri.parse("geo:0,0?q=-33.8666,151.1957(Google+Sydney)");
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            startActivity(mapIntent);

                        }
                    }, 1000);
                }
            });
            btnDatePicker= (TextView) findViewById(R.id.btn_date);
            btnDatePicker2=(TextView)findViewById(R.id.btn_time);
            txtDate=(TextView) findViewById(R.id.btn_date);
            txtDate2=(TextView) findViewById(R.id.btn_time);

            btnDatePicker.setOnClickListener(this);
            btnDatePicker2.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if (v == btnDatePicker) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
            if (v == btnDatePicker2) {

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                txtDate2.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        }}

