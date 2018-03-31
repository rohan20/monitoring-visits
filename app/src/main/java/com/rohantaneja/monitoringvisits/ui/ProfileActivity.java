package com.rohantaneja.monitoringvisits.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.model.User;
import com.rohantaneja.monitoringvisits.data.MinistryDatabase;

public class ProfileActivity extends AppCompatActivity {
Button logout;
TextView name,email,isAdmin;
SharedPreferences sharedPreferences;
Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setTitle("My Profile");

        sharedPreferences = getSharedPreferences("SIH",MODE_PRIVATE);
        String userString = sharedPreferences.getString("user",null);
        final MinistryDatabase mdb=MinistryDatabase.getInstance(ProfileActivity.this);
        Log.wtf("all",mdb.getMinistryDAO().getAllTasks().toString());
        logout = findViewById(R.id.logout);
        if(userString != null) {
            User user = new Gson().fromJson(userString, User.class);
            email.setText(user.getEmail());
            name.setText(user.getName());
            isAdmin.setText("Admin Status: " + (user.isAdmin()?"Admin":"No"));
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().apply();
                Log.wtf("shp",sharedPreferences.getAll().toString());
                //Log.wtf("all",mdb.getMinistryDAO().getAllTasks().toString());
                Intent intent = new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}
