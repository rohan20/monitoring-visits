package com.rohantaneja.monitoringvisits.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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

    public QuestionsViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        optionsLinearLayout = itemView.findViewById(R.id.options_linear_layout);
    }

    public void bindData(Question question) {
//        for (int i = 0; i < question.getOptions().size(); i++)
        TextView optionTextView;
        View view = null;

        for (int j = 0; j < 5; j++) {
            switch (question.getFormat()) {
                case Constants.TYPE_CHECKBOX:
                    view = LayoutInflater.from(context).inflate(R.layout.item_option_checkbox, null);
                    RadioButton radioButton = itemView.findViewById(R.id.option_radiobutton);
                    optionTextView = itemView.findViewById(R.id.option_text_view);
                    //                    optionTextView.setText(question.getOptions().get(j));
                    break;

                case Constants.TYPE_RADIOBUTTON:
                    view = LayoutInflater.from(context).inflate(R.layout.item_option_radiobutton, null);
                    CheckBox checkBox = itemView.findViewById(R.id.option_checkbox);
                    optionTextView = itemView.findViewById(R.id.option_text_view);
//                    optionTextView.setText(question.getOptions().get(j));
                    break;
            }

            optionsLinearLayout.addView(view);

        }

    }
}
