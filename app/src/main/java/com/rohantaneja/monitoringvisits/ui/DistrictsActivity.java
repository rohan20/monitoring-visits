package com.rohantaneja.monitoringvisits.ui;

import android.content.Intent;
import android.app.ExpandableListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.ExpandableListView;

import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.adapter.ExpandableDistrictsAdapter;
import com.rohantaneja.monitoringvisits.model.District;

import java.util.ArrayList;
import java.util.List;
import com.rohantaneja.monitoringvisits.model.District;

public class DistrictsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_districts);

        ExpandableListView districtsExpandableListView = findViewById(R.id.districts_expandable_list_view);
        ExpandableDistrictsAdapter districtsAdapter = new ExpandableDistrictsAdapter(this, prepareData());
        districtsExpandableListView.setAdapter(districtsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_districts, menu);
        return true;
    }

    private List<District> prepareData() {
        List<District> districtsList = new ArrayList<>();
        districtsList.add(new District(1, "North East", 122, 66, 594));
        districtsList.add(new District(2, "South East", 251, 87, 485));
        districtsList.add(new District(3, "North West", 11, 9, 2));
        districtsList.add(new District(4, "South West", 35, 24, 99));
        return districtsList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.profile) {
            Intent intent = new Intent(DistrictsActivity.this,ProfileActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

