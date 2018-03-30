package com.rohantaneja.monitoringvisits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rohantaneja.monitoringvisits.ui.LoginActivity;
import com.rohantaneja.monitoringvisits.ui.SignUpActivity;
import com.rohantaneja.monitoringvisits.ui.TaskDetailActivity;

public class MainActivity extends AppCompatActivity {

    Button login,signup,Mapact,checkboxac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        signup = findViewById(R.id.button_signup);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }


    public void checkboxonclick(View view) {
        Intent intent = new Intent(MainActivity.this,CheckboxActivity.class);
        startActivity(intent);
    }

    public void taskdetailonclick(View view) {
        Intent intent = new Intent(MainActivity.this, TaskDetailActivity.class);
        startActivity(intent);
    }
}
