package com.rohantaneja.monitoringvisits.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.app.ExpandableListActivity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.Utils;
import com.rohantaneja.monitoringvisits.adapter.ExpandableDistrictsAdapter;
import com.rohantaneja.monitoringvisits.data.MinistryDatabase;
import com.rohantaneja.monitoringvisits.data.dao.MinistryDAO;
import com.rohantaneja.monitoringvisits.model.District;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.rohantaneja.monitoringvisits.model.District;
import com.rohantaneja.monitoringvisits.model.Programme;
import com.rohantaneja.monitoringvisits.model.Task;
import com.rohantaneja.monitoringvisits.model.TaskData;
import com.rohantaneja.monitoringvisits.model.User;
import com.rohantaneja.monitoringvisits.model.Visit;
import com.rohantaneja.monitoringvisits.network.RESTAdapter;
import com.rohantaneja.monitoringvisits.network.response.TasksResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DistrictsActivity extends BaseActivity {

    SharedPreferences sharedPreferences;
    Bundle bundle;

    ProgressDialog dialog;
    ExpandableDistrictsAdapter districtsAdapter;

    ArrayList<TaskData> districtTaskData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_districts);

        sharedPreferences = getSharedPreferences("SIH",MODE_PRIVATE);
        bundle=getIntent().getExtras();
        String userString = sharedPreferences.getString("user",null);
        if(userString != null){
            User  user= new Gson().fromJson(userString, User.class);
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
                        Utils.saveRetrofitTasks(tasksResponse.taskList,DistrictsActivity.this);
                        refreshData();
                    }
                    dialog.dismiss();

                }

                @Override
                public void onFailure(Call<TasksResponse> call, Throwable t) {
                    dialog.dismiss();
                }
            });


        }



        ExpandableListView districtsExpandableListView = findViewById(R.id.districts_expandable_list_view);
        districtsAdapter = new ExpandableDistrictsAdapter(this, districtTaskData);
        districtsExpandableListView.setAdapter(districtsAdapter);
        districtsExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                return false;
            }
        });
    }

    public void refreshData(){
        List<Task> tasks = MinistryDatabase.getInstance(this).getMinistryDAO().getAllTasks();
        if(tasks != null){
            HashMap<String,ArrayList<Task>> districtTasks = new HashMap<>();
            for(Task task:tasks){
                String districtName = task.getAddress().getDistrict();
                if(districtName != null){
                    if(districtTasks.containsKey(districtName)){
                        districtTasks.get(districtName).add(task);
                    }
                    else {
                        ArrayList<Task> dTasks = new ArrayList<>();
                        dTasks.add(task);
                        districtTasks.put(districtName,dTasks);

                    }
                }
            }
            districtTaskData.clear();
            for(String key: districtTasks.keySet()){
                ArrayList<Task> dTaskList = districtTasks.get(key);
                TaskData taskData= new TaskData();
                taskData.setTitle(key);
                taskData.setType(TaskData.TYPE_DISTRICT);
                for(Task task:dTaskList){
                    if(task.getTaskStatus().getStatus().toLowerCase().equals("completed")){
                        taskData.setTasksCompleted(taskData.getTasksCompleted() + 1);
                        taskData.setTasksAssigned(taskData.getTasksAssigned() + 1);
                    }
                    else {
                        taskData.setTasksAssigned(taskData.getTasksAssigned() + 1);
                    }
                    List<Visit> visits = MinistryDatabase.getInstance(DistrictsActivity.this).getMinistryDAO().getVisitsForTask(task.getId());
                    int count = visits.size();
                    taskData.setVisits(taskData.getVisits() + count);
                    districtTaskData.add(taskData);
                }
            }

            if(districtsAdapter != null){
                districtsAdapter.notifyDataSetChanged();
            }



        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_districts, menu);
        return true;
    }

    private List<District> prepareData() {
        List<District> districtsList = new ArrayList<>();
        districtsList.add(new District(1, "North East", 12, 6, 9));
        districtsList.add(new District(2, "South East", 25, 18, 40));
        districtsList.add(new District(3, "North West", 11, 9, 9));
        districtsList.add(new District(4, "South West", 35, 24, 30));
        return districtsList;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.profile) {
            Intent intent = new Intent(DistrictsActivity.this,ProfileActivity.class);
            //intent.putExtras(bundle);
            startActivity(intent);
            return true;
        }
        else if(id==R.id.logout)
        {
            sharedPreferences.edit().clear().apply();
            Log.wtf("shp",sharedPreferences.getAll().toString());
            Intent intent = new Intent(DistrictsActivity.this,LoginActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}

