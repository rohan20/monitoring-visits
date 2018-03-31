package com.rohantaneja.monitoringvisits.ui;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.Utils;
import com.rohantaneja.monitoringvisits.adapter.VisitTaskAdapter;
import com.rohantaneja.monitoringvisits.model.User;
import com.rohantaneja.monitoringvisits.network.RESTAdapter;
import com.rohantaneja.monitoringvisits.network.response.TasksResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewTaskActivity extends AppCompatActivity {
SharedPreferences sharedPreferences;
Bundle bundle;

RecyclerView recyclerView;
VisitTaskAdapter adapter;

    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        sharedPreferences = getSharedPreferences("SIH",MODE_PRIVATE);
        recyclerView=findViewById(R.id.recyclerView1);

        bundle=getIntent().getExtras();
        String userString = sharedPreferences.getString("user",null);
        if(userString != null) {
            User user = new Gson().fromJson(userString, User.class);
            Call<TasksResponse> call = RESTAdapter.getInstance().getMinistryDataAPI().getTasks(user.getId());
            dialog = new ProgressDialog(this);
            dialog.setCancelable(false);
            dialog.setMessage("Loading...");
            dialog.show();
            call.enqueue(new Callback<TasksResponse>() {
                @Override
                public void onResponse(Call<TasksResponse> call, Response<TasksResponse> response) {
                    TasksResponse tasksResponse = response.body();
                    if(tasksResponse != null){
                        adapter=new VisitTaskAdapter(tasksResponse);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewTaskActivity.this);

                        recyclerView.setLayoutManager(layoutManager);

                        recyclerView.setAdapter(adapter);
                    }
                    dialog.dismiss();

                }

                @Override
                public void onFailure(Call<TasksResponse> call, Throwable t) {
                    dialog.dismiss();
                }
            });
        }
    }
}
