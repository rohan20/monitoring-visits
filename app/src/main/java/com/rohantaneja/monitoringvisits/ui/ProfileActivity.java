package com.rohantaneja.monitoringvisits.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rohantaneja.monitoringvisits.R;
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
        sharedPreferences = getSharedPreferences("SIH",MODE_PRIVATE);
        bundle=getIntent().getExtras();
        name=findViewById(R.id.dispname);
        email=findViewById(R.id.dispemail);
        isAdmin = findViewById(R.id.dispisAdmin);
        if(bundle!=null) {
            if (bundle.containsKey("email"))
                email.setText(bundle.getString("email"));
            if (bundle.containsKey("name")) ;
                name.setText(bundle.getString("name"));
            if(bundle.containsKey("isAdmin"))
                isAdmin.setText("isAdmin: " + (bundle.getBoolean("isAdmin")?"Yes":"No"));
        }
        final MinistryDatabase mdb=MinistryDatabase.getInstance(ProfileActivity.this);
        Log.wtf("all",mdb.getMinistryDAO().getAllTasks().toString());
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().clear().apply();
                Log.wtf("shp",sharedPreferences.getAll().toString());

                mdb.getMinistryDAO().deleteProgrammes();
                mdb.getMinistryDAO().deleteQuestionOptions();
                mdb.getMinistryDAO().deleteQuestions();
                mdb.getMinistryDAO().deleteTasks();
                mdb.getMinistryDAO().deleteVisits();
                //Log.wtf("all",mdb.getMinistryDAO().getAllTasks().toString());
                Intent intent = new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}
