package com.rohantaneja.monitoringvisits.ui;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.data.MinistryDatabase;
import com.rohantaneja.monitoringvisits.model.Question;
import com.rohantaneja.monitoringvisits.model.QuestionAnswer;
import com.rohantaneja.monitoringvisits.model.QuestionOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionnaireActivity extends BaseActivity {

    LinearLayout formLayout;
    List<Question> questions = new ArrayList<>();
    HashMap<Integer,QuestionView> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        formLayout = findViewById(R.id.formContainer);

        QuestionOption option = new QuestionOption();
        option.setId(1);
        option.setQuestionId(1);
        option.setTitle("Option Title");
        ArrayList<QuestionOption> options = new ArrayList<>();
        options.add(option);
        Question q = new Question(1,"title",true,"District Visit",1,"text",options);

        QuestionOption option1 = new QuestionOption();
        option1.setId(2);
        option1.setQuestionId(2);
        option1.setTitle("Option Title 1");

        QuestionOption option2 = new QuestionOption();
        option2.setId(3);
        option2.setQuestionId(2);
        option2.setTitle("Option Title 2");
        ArrayList<QuestionOption> options2 = new ArrayList<>();
        options2.add(option1);
        options2.add(option2);
        Question question2 = new Question(2,"title 2",true,"District Visit",1,"multiple choice",options2);

        questions.add(q);
        questions.add(question2);

        for(Question question:questions){
            QuestionAnswer answer = MinistryDatabase.getInstance(this).getMinistryDAO().getAnswers(question.getId());
            //question.setOptions(questionOptions);
            QuestionView view = new QuestionView(this,question,answer);
            map.put(question.getId(),view);
            formLayout.addView(view);
        }



//        Button saveButton = findViewById(R.id.save_button);
//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                showToast(getString(R.string.saved));
//                showNoInternetAlert();
//            }
//        });
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showNotification();
//            }
//        }, 3000);

    }

    private void showNoInternetAlert() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(QuestionnaireActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(QuestionnaireActivity.this);
        }
        builder.setTitle("Your data has been saved offline")
                .setMessage("System would sync data when you go back online")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton("Turn on internet now", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void showNotification() {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "0")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("एक नया कार्य आपको सौंपा गया है")
                .setContentText("जिला: उत्तर पश्चिम")
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        mBuilder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, mBuilder.build());
    }

    public void submit(View view){
        for(Question question:questions){
            QuestionView questionView = map.get(question.getId());
            if(questionView != null){
                QuestionAnswer answer = questionView.getAnswer();
                MinistryDatabase.getInstance(this).getMinistryDAO().insertAnswer(answer);
            }
        }
        showToast("Form Submitted!!");
        finish();
    }
}
