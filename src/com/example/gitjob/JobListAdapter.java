package com.example.gitjob;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//setting beer list on Adapter
public class JobListAdapter extends ArrayAdapter<JobInfoItems> {

    // LayoutInflater from layout xml create View 
    private LayoutInflater inflater;

    // constructor 
    public JobListAdapter(Context context, int resourceId,
        List<JobInfoItems> items) {
        super(context, resourceId, items);

        // getting LayoutInfalter from Context
        inflater =
            (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //json data transfers to listview and view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView != null) {
            view = convertView;
        } else {
            // create new convertView if null 
            view = inflater.inflate(R.layout.list_row, null);
        }

        // get selected item 
        JobInfoItems item = getItem(position);

        // setting job title on View   
		TextView jobTitle  = (TextView) view.findViewById(R.id.tv_jobTitle );
        jobTitle.setText(item.getjobTitle());
        jobTitle.setTextSize(17);
        TextView company  = (TextView) view.findViewById(R.id.tv_company );
        company.setText(item.getCompany());
        company.setTextSize(13);
        TextView type = (TextView) view.findViewById(R.id.tv_type);
        type.setText(item.getType());
        type.setTextSize(13);
		TextView location  = (TextView) view.findViewById(R.id.tv_location );
        location.setText(item.getLocation());
        location.setTextSize(13);
        TextView createdAt = (TextView) view.findViewById(R.id.tv_createdAt);
        createdAt.setText(item.getCreatedAt());
        createdAt.setTextSize(13);

        return view;
    }
}