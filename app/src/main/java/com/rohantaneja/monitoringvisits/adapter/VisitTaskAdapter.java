package com.rohantaneja.monitoringvisits.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.model.Task;
import com.rohantaneja.monitoringvisits.network.response.TasksResponse;

import java.util.ArrayList;

/**
 * Created by Shiv Kumar Aggarwal on 31-03-2018.
 */

public class VisitTaskAdapter extends RecyclerView.Adapter<VisitTaskAdapter.VisitTaskViewHolder> {

        public interface TaskClickListener {
            void onTaskClick(Task task);
        }

        private TasksResponse dataList;
        private TaskClickListener listener;

        public VisitTaskAdapter(TasksResponse dataList,TaskClickListener listener) {
            this.dataList = dataList;
            this.listener = listener;
        }

        @Override
        public VisitTaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.card_task2, parent, false);
            return new VisitTaskViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final VisitTaskViewHolder holder, int position) {
            Task task = dataList.taskList.get(position);
            holder.tasknum.setText("TASK#"+position);
            holder.deadline.setText(task.getDeadline());
            Task.Address address = task.getAddress();
            holder.address.setText(address.getAddress()+", " + address.getDistrict()+", " + address.getState()+"-"+address.getPincode());
            holder.visitType.setText(task.getVisitType());
            holder.status.setText(task.getTaskStatus().getStatus());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Task taskClicked = dataList.taskList.get(holder.getAdapterPosition());
                    listener.onTaskClick(taskClicked);
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.taskList.size();
        }

        class VisitTaskViewHolder extends RecyclerView.ViewHolder {

            TextView tasknum, deadline, address,visitType,status;
            View itemView;

            VisitTaskViewHolder(View itemView) {
                super(itemView);
                tasknum = (TextView) itemView.findViewById(R.id.tasknum);
                deadline = (TextView) itemView.findViewById(R.id.deadline);
                address = (TextView) itemView.findViewById(R.id.address);
                visitType = (TextView) itemView.findViewById(R.id.visitType);
                status = itemView.findViewById(R.id.status);
                this.itemView = itemView;

            }
        }
    }

