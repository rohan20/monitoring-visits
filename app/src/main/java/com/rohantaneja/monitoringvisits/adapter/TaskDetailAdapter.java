package com.rohantaneja.monitoringvisits.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rohantaneja.monitoringvisits.R;
import com.rohantaneja.monitoringvisits.model.Visit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Shiv Kumar Aggarwal on 31-03-2018.
 */

public class TaskDetailAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    Visit tempValues=null;
    int i=0;
    String tname;

    /*************  CustomAdapter Constructor *****************/
    public TaskDetailAdapter(Activity a, ArrayList d,String name,Resources resLocal) {

        /********** Take passed values **********/
        activity = a;
        data=d;
        res = resLocal;
        tname=name;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {

        if(data.size()<=0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{

        public TextView tname;
        public TextView dateAssigned,status,taskdet;


    }

    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.task_detail_list_item, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.tname = (TextView) vi.findViewById(R.id.textView2);
            holder.dateAssigned=(TextView)vi.findViewById(R.id.btn_date);
            holder.status=vi.findViewById(R.id.action_status);
            holder.taskdet=vi.findViewById(R.id.textView4);

            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(data.size()<=0)
        {
            holder.tname.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = (Visit) data.get( position );

            /************  Set Model values in Holder elements ***********/

            holder.tname.setText(tname);
            holder.dateAssigned.setText( tempValues.getTask().getCreatedAt() );
            holder.status.setText(tempValues.getAction().getAction());
            holder.taskdet.setText(tempValues.getTask().getProgramme().getName());

        }
        return vi;
    }




}