package com.rohantaneja.monitoringvisits.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rohantaneja.monitoringvisits.BaseActivity;
import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.adapter.VisitQuestionsAdapter;
import com.rohantaneja.monitoringvisits.model.Question;

import java.util.ArrayList;
import java.util.List;

public class VisitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);

        //TODO ask for location -> show empty view if no location, else show fields to add visit
        //TODO buttons to start questionnaire or cancel visit
        //TODO programmatically display ques
        //TODO check for internet while saving, if no internet, save to local

        List<Question> questionList = prepareData();

        RecyclerView questionsRecyclerView = findViewById(R.id.questions_recycler_view);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        VisitQuestionsAdapter adapter = new VisitQuestionsAdapter(questionList, this);
        questionsRecyclerView.setAdapter(adapter);
    }

    private List<Question> prepareData() {
        List<Question> questionList = new ArrayList<>();

        List<String> optionsList = new ArrayList<>();
        optionsList.add("A");
        optionsList.add("B");
        optionsList.add("C");
        optionsList.add("D");

        List<String> optionsList2 = new ArrayList<>();
        optionsList2.add("A");
        optionsList2.add("C");

        questionList.add(new Question(1, "Water quality?", true, "Door to Door", 45, "radio button", optionsList));
//        questionList.add(new Question(2, "Water quality??", false, "Door to Door", 123, "check box", optionsList));
//        questionList.add(new Question(3, "Water quality???", true, "Door to Door", 23, "radio button", optionsList2));
//        questionList.add(new Question(3, "Water quality???", true, "Door to Door", 23, "radio button", optionsList2));
//        questionList.add(new Question(3, "Water quality???", true, "Door to Door", 23, "radio button", optionsList2));
//        questionList.add(new Question(3, "Water quality???", true, "Door to Door", 23, "radio button", optionsList2));

        return questionList;
    }
}
