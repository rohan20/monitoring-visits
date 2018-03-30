package com.rohantaneja.monitoringvisits.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.rohantaneja.monitoringvisits.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by rohantaneja on 30/03/18.
 */

public class DistrictViewholder extends GroupViewHolder {

    private TextView districtNameTextView;

    public DistrictViewholder(View itemView) {
        super(itemView);
        districtNameTextView = itemView.findViewById(R.id.district_name_text_view);
    }

    public void bindData(ExpandableGroup districtGroup){
        districtNameTextView.setText(districtGroup.getTitle());
    }
}
