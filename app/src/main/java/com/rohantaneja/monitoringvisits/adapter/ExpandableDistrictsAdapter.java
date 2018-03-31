package com.rohantaneja.monitoringvisits.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.model.District;
import com.rohantaneja.monitoringvisits.model.TaskData;

import java.util.List;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class ExpandableDistrictsAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<TaskData> districtsList;

    public ExpandableDistrictsAdapter(Context context, List<TaskData> districtsList) {
        this.context = context;
        this.districtsList = districtsList;
    }

    @Override
    public int getGroupCount() {
        return districtsList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return districtsList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            return inflater.inflate(R.layout.list_item_district, null);
        }

        TextView districtNameTextView = view.findViewById(R.id.district_name_text_view);
        districtNameTextView.setText(districtsList.get(groupPosition).getTitle());
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            return inflater.inflate(R.layout.list_item_district_statistics, null);
        }

        TextView tasksAssingedTextView = view.findViewById(R.id.task_assigned_statistic_value);
        TextView tasksCompletedTExtView = view.findViewById(R.id.task_completed_statistic_value);
        TextView visitsMadeTextView = view.findViewById(R.id.visits_made_statistic_value);
        tasksAssingedTextView.setText(String.valueOf(districtsList.get(groupPosition).getTasksAssigned()));
        tasksCompletedTExtView.setText(String.valueOf(districtsList.get(groupPosition).getTasksCompleted()));
        visitsMadeTextView.setText(String.valueOf(districtsList.get(groupPosition).getVisits()));

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
