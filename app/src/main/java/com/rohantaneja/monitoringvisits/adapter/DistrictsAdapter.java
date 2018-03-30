package com.rohantaneja.monitoringvisits.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.adapter.viewholder.DistrictStatisticViewholder;
import com.rohantaneja.monitoringvisits.adapter.viewholder.DistrictViewholder;
import com.rohantaneja.monitoringvisits.model.DistrictStatisticList;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class DistrictsAdapter extends ExpandableRecyclerViewAdapter<DistrictViewholder, DistrictStatisticViewholder> {

    private Context context;
    private LayoutInflater inflater;

    public DistrictsAdapter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public DistrictViewholder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View districtItemView = inflater.inflate(R.layout.list_item_district, parent, false);
        return new DistrictViewholder(districtItemView);
    }

    @Override
    public DistrictStatisticViewholder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View districtStatisticsItemView = inflater.inflate(R.layout.list_item_district_statistics, parent, false);
        return new DistrictStatisticViewholder(districtStatisticsItemView);
    }

    @Override
    public void onBindChildViewHolder(DistrictStatisticViewholder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        holder.bindData((DistrictStatisticList)group.getItems().get(childIndex));
    }

    @Override
    public void onBindGroupViewHolder(DistrictViewholder holder, int flatPosition, ExpandableGroup group) {
        holder.bindData(group);
    }
}
