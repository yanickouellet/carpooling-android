package com.yanickouellet.carpooling.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yanickouellet.carpooling.models.RunRequest;
import com.yanickouellet.carpooling.presenters.DatePresenter;

import java.util.List;

public class RunRequestsAdapter extends ArrayAdapter<RunRequest> {
    public RunRequestsAdapter(Context context, int listViewResourceId, int textViewResourceId, List<RunRequest> requests) {
        super(context, listViewResourceId, textViewResourceId, requests);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView row = (TextView) super.getView(position, convertView, parent);

        RunRequest req = getItem(position);

        row.setText(DatePresenter.presentRunDate(req, getContext()));

        return row;
    }
}
