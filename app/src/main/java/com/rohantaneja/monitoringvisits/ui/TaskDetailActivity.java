package com.rohantaneja.monitoringvisits.ui;

/**
 * Created by Mansi sharma on 30-03-2018.
 */
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.adapter.TaskDetailAdapter;
import com.rohantaneja.monitoringvisits.model.User;
import com.rohantaneja.monitoringvisits.network.RESTAdapter;
import com.rohantaneja.monitoringvisits.network.response.VisitsResponse;


import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskDetailActivity extends FragmentActivity implements
    View.OnClickListener {

        TextView btnDatePicker, btnDatePicker2;
        TextView txtDate, txtDate2;
    ProgressDialog dialog;
        ListView listView;
    TaskDetailAdapter adapter;
    TaskDetailActivity tda=null;
        private int mYear, mMonth, mDay, mHour, mMinute;
        Marker mCurrLocationMarker;
        GoogleMap mMap;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.taskdetailactivity);
            tda=this;
            Button btn_click = (Button) findViewById(R.id.btn_click);
            listView=findViewById(R.id.listView);
            Bundle bundle = getIntent().getExtras();
            final String name = bundle.getString("name");
           /* btn_click.setOnClickListener(new View.OnClickListener() {

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
*/
            Call<VisitsResponse> call = RESTAdapter.getInstance().getMinistryDataAPI().getVisits(getIntent().getIntExtra("id",-1));
            Log.wtf("URL Called", call.request().url() + "");
            dialog = new ProgressDialog(this);
            dialog.setCancelable(false);
            dialog.setMessage("Loading...");
            dialog.show();
            call.enqueue(new Callback<VisitsResponse>(){

                @Override
                public void onResponse(Call<VisitsResponse> call, Response<VisitsResponse> response) {
                 VisitsResponse visitsResponse = response.body();
                 adapter=new TaskDetailAdapter(tda,visitsResponse.visitList,name,getResources());
                 listView.setAdapter(adapter);
                    Toast.makeText(tda,"success!",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }

                @Override
                public void onFailure(Call<VisitsResponse> call, Throwable t) {
                    Toast.makeText(tda,"no response!",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
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

