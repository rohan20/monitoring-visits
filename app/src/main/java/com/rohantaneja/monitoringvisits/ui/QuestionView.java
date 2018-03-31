package com.rohantaneja.monitoringvisits.ui;

import android.content.Context;
import android.text.Editable;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rohantaneja.monitoringvisits.model.Question;
import com.rohantaneja.monitoringvisits.model.QuestionAnswer;
import com.rohantaneja.monitoringvisits.model.QuestionOption;
import com.rohantaneja.monitoringvisits.util.Constants;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by ralph on 31/03/18.
 */

public class QuestionView extends LinearLayout {

    LinearLayout bodyContainer;
    Question q;
    QuestionAnswer answer;

    public QuestionView(Context context, Question question,QuestionAnswer ans) {
        super(context);
        q = question;
        setOrientation(VERTICAL);
        Gson gson = new Gson();
        ArrayList<String> values = new ArrayList<>();
        if(ans != null){
            answer = ans;
            values = gson.fromJson(ans.getValue(),ArrayList.class);
        }


        TextView textView = new TextView(context);
        textView.setText(question.getTitle());
        textView.setPadding(16,16,16,0);
        addView(textView);

        bodyContainer = new LinearLayout(context);
        bodyContainer.setPadding(16,16,16,0);
        bodyContainer.setOrientation(VERTICAL);
        addView(bodyContainer);
        List<QuestionOption> options = question.getOptions();

        switch (question.getFormat()){
            case Constants.TYPE_CHECKBOX:

                for(QuestionOption option:options){
                    CheckBox checkBox = new CheckBox(context);
                    for(String val:values){
                        if(val.equals(option.getTitle())){
                            checkBox.setChecked(true);
                        }
                    }
                    checkBox.setText(option.getTitle());
                    checkBox.setPadding(0,0,0,16);
                    bodyContainer.addView(checkBox);
                }
                break;
            case Constants.TYPE_RADIOBUTTON:
                RadioGroup group = new RadioGroup(context);
                group.setTag(question);
                for(QuestionOption option:options){

                    RadioButton radioButton = new RadioButton(context);
                    for(String val:values){
                        if(val.equals(option.getTitle())){
                            radioButton.setChecked(true);
                        }
                    }
                    radioButton.setText(option.getTitle());
                    radioButton.setPadding(0,0,0,16);
                    group.addView(radioButton);
                }
                bodyContainer.addView(group);
                break;
            case Constants.TYPE_TEXT:
                EditText editText = new EditText(context);
                if(options != null && options.size() > 0){
                    editText.setHint(options.get(0).getTitle());
                }
                if(values.size() > 0){
                    editText.setText(values.get(0));
                }

                editText.setPadding(0,0,0,16);
                bodyContainer.addView(editText);
                break;
        }
    }

    public QuestionAnswer getAnswer(){
        Gson gson = new Gson();
        if(answer == null){
            answer = new QuestionAnswer(UUID.randomUUID().toString(),"",q.getId());
        }
        List<QuestionOption> options = q.getOptions();
        ArrayList<String> values = new ArrayList<>();
        switch (q.getFormat()){
            case Constants.TYPE_CHECKBOX:


                for(int i = 0;i<bodyContainer.getChildCount();i++ ){
                    QuestionOption option = options.get(i);
                    CheckBox checkBox = (CheckBox) bodyContainer.getChildAt(i);
                    if(checkBox.isChecked()){
                        values.add(option.getTitle());
                    }
                }
                break;
            case Constants.TYPE_RADIOBUTTON:
                RadioGroup group = (RadioGroup) bodyContainer.getChildAt(0);
                int id = group.getCheckedRadioButtonId();
                RadioButton button = group.findViewById(id);
                values.add(button.getText().toString());
                break;
            case Constants.TYPE_TEXT:
                EditText editText = (EditText)bodyContainer.getChildAt(0);
                Editable val = editText.getEditableText();
                if(val != null){
                    values.add(val.toString());
                }
                break;

        }
        answer.setValue(gson.toJson(values));
        return answer;
    }
}
