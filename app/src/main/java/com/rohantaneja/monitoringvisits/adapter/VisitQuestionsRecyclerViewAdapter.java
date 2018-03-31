package com.rohantaneja.monitoringvisits.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.adapter.viewholder.QuestionsViewHolder;
import com.rohantaneja.monitoringvisits.model.Question;

import java.util.List;

/**
 * Created by rohantaneja on 31/03/18.
 */
public class VisitQuestionsRecyclerViewAdapter extends RecyclerView.Adapter<QuestionsViewHolder> {

    private final Context context;
    private List<Question> questionList;

    public VisitQuestionsRecyclerViewAdapter(List<Question> items, Context context) {
        this.questionList = items;
        this.context = context;
    }

    @Override
    public QuestionsViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionsViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(QuestionsViewHolder holder, int position) {
        Question questionItem = questionList.get(position);
        holder.bindData(questionItem);
    }

    @Override
    public int getItemCount() {
        if (questionList == null) {
            return 0;
        }
        return questionList.size();
    }
}