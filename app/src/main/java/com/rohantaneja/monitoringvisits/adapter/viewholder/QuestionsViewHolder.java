package com.rohantaneja.monitoringvisits.adapter.viewholder;

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
