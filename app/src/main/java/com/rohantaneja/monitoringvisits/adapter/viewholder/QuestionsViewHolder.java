package com.rohantaneja.monitoringvisits.adapter.viewholder;

import android.arch.persistence.room.util.StringUtil;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rohantaneja.monitoringvisits.util.Constants;

import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.model.Question;

import java.util.List;

/**
 * Created by rohantaneja on 31/03/18.
 */

public class QuestionsViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private LinearLayout optionsLinearLayout;
    private TextView questionTextView;

    public QuestionsViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        optionsLinearLayout = itemView.findViewById(R.id.options_linear_layout);
        questionTextView = itemView.findViewById(R.id.question_text_view);
    }

    public void bindDataDynamically(Question question) {

        View questionView;

        switch (question.getFormat()) {
            case Constants.TYPE_CHECKBOX:
                questionView = LayoutInflater.from(context).inflate(R.layout.layout_checkbox_question, null);

                CheckBox checkBox1 = questionView.findViewById(R.id.question_checkbox_1);
                CheckBox checkBox2 = questionView.findViewById(R.id.question_checkbox_2);
                CheckBox checkBox3 = questionView.findViewById(R.id.question_checkbox_3);
                CheckBox checkBox4 = questionView.findViewById(R.id.question_checkbox_4);

                List<String> optionsList = question.getOptions();

                if (optionsList.get(0).isEmpty())
                    checkBox1.setVisibility(View.GONE);
                else
                    checkBox1.setText(optionsList.get(0));
                if (optionsList.get(1).isEmpty())
                    checkBox2.setVisibility(View.GONE);
                else
                    checkBox2.setText(optionsList.get(1));
                if (optionsList.get(2).isEmpty())
                    checkBox3.setVisibility(View.GONE);
                else
                    checkBox3.setText(optionsList.get(2));
                if (optionsList.get(3).isEmpty())
                    checkBox4.setVisibility(View.GONE);
                else
                    checkBox4.setText(optionsList.get(3));
                
                break;

            case Constants.TYPE_RADIOBUTTON:

                break;

            case Constants.TYPE_TEXT:

                break;
        }
    }

    public void bindData(Question question) {

        questionTextView.setText(question.getTitle());
        optionsLinearLayout.removeAllViews();

        for (int j = 0; j < question.getOptions().size(); j++) {
            View singleOptionView = LayoutInflater.from(context).inflate(R.layout.item_option, null);

            RadioButton radioButton = singleOptionView.findViewById(R.id.option_radiobutton);
            CheckBox checkBox = singleOptionView.findViewById(R.id.option_checkbox);

            switch (question.getFormat()) {
                case Constants.TYPE_CHECKBOX:
                    radioButton.setVisibility(View.GONE);
                    checkBox.setVisibility(View.VISIBLE);
                    checkBox.setText(question.getOptions().get(j));
                    break;

                case Constants.TYPE_RADIOBUTTON:
                    radioButton.setVisibility(View.VISIBLE);
                    checkBox.setVisibility(View.GONE);
                    radioButton.setText(question.getOptions().get(j));
                    break;
            }

            optionsLinearLayout.addView(singleOptionView);

        }

    }

}
