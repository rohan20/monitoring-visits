package com.rohantaneja.monitoringvisits.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.model.TaskCard;

import java.util.ArrayList;

/**
 * Created by Shiv Kumar Aggarwal on 30-03-2018.
 */

public class ViewPagerRecyclerAdapter extends RecyclerView.Adapter<ViewPagerRecyclerAdapter.CardHolder>{

        private ArrayList<TaskCard> dataList;

        public ViewPagerRecyclerAdapter(ArrayList<TaskCard> dataList) {
            this.dataList = dataList;
        }

        @Override
        public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.card_visit, parent, false);
            return new CardHolder(view);
        }

        @Override
        public void onBindViewHolder(CardHolder holder, int position) {
            holder.visitnum.setText(dataList.get(position).getVisitnum());
            holder.taskname.setText(dataList.get(position).getTaskname());
            holder.orgname.setText(dataList.get(position).getOrgname());
            holder.date.setText(dataList.get(position).getDate());
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        class CardHolder extends RecyclerView.ViewHolder {

            TextView visitnum, taskname,orgname,date;

            CardHolder(View itemView) {
                super(itemView);
                visitnum = (TextView) itemView.findViewById(R.id.textview_visitnum);
                taskname = (TextView) itemView.findViewById(R.id.textView_taskname);
                orgname = (TextView) itemView.findViewById(R.id.textView_orgname);
                date = itemView.findViewById(R.id.textView_date);
            }
        }
}
