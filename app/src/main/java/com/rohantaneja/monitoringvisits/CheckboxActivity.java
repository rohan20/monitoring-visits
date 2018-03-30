package com.rohantaneja.monitoringvisits;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    final Context context = this;
    private Button button;
    private CheckBox result;
    boolean[] checked_state = new boolean[3];
    CharSequence[] day_check = {"Sunday", "Monday", "Tuesday"};
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkboxactivity);

        button = (Button) findViewById(R.id.abc);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.checkboxactivity, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                alertDialogBuilder.setView(promptsView);


                AlertDialog.Builder builder1 = new AlertDialog.Builder(CheckboxActivity.this)
                        .setTitle("Choose Days")
                        .setMultiChoiceItems(day_check, null, new DialogInterface.OnMultiChoiceClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                checked_state[which] = isChecked;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                                        String display_checked_days = "";
                                        for (int i = 0; i < 3; i++) {
                                            if (checked_state[i] == true) {
                                                display_checked_days = display_checked_days + " " + day_check[i];
                                            }
                                        }
                                        Toast.makeText(CheckboxActivity.this, "The selected day(s) -" + display_checked_days, Toast.LENGTH_LONG).show();
                                        display_checked_days = null;


                                        for (int i = 0; i < checked_state.length; i++) {
                                            if (checked_state[i] == true) {
                                                checked_state[i] = false;
                                            }
                                        }

                                        dialog.dismiss();
                                    }
                                }
                        );
                AlertDialog alertdialog1 = builder1.create();
                alertdialog1.show();


            }
        });
    }}