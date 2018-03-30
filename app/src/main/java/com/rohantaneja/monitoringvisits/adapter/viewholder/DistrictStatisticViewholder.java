package com.rohantaneja.monitoringvisits.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.rohantaneja.monitoringvisits.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class DistrictStatisticViewholder extends ChildViewHolder {

    private TextView tasksAssignedValueTextView;
    private TextView tasksCompletedValueTextView;
    private TextView visitsNumberTextView;

    public DistrictStatisticViewholder(View itemView) {
        super(itemView);
        tasksAssignedValueTextView = itemView.findViewById(R.id.task_assigned_statistic_value);
        tasksCompletedValueTextView = itemView.findViewById(R.id.task_completed_statistic_value);
        visitsNumberTextView = itemView.findViewById(R.id.visits_completed_statistic_value);
    }

    public void bindData(DistrictStatisticList districtStatisticList) {
        tasksAssignedValueTextView.setText(String.valueOf(districtStatisticList.getDistrictStatisticList().get(0).getStatisticValue()));
        tasksCompletedValueTextView.setText(String.valueOf(districtStatisticList.getDistrictStatisticList().get(1).getStatisticValue()));
        visitsNumberTextView.setText(String.valueOf(districtStatisticList.getDistrictStatisticList().get(2).getStatisticValue()));
    }

}
