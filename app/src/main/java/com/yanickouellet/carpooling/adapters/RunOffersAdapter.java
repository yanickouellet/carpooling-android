package com.yanickouellet.carpooling.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yanickouellet.carpooling.models.BaseRun;
import com.yanickouellet.carpooling.models.RunOffer;
import com.yanickouellet.carpooling.models.RunRequest;
import com.yanickouellet.carpooling.presenters.DatePresenter;

import java.util.List;

public class RunOffersAdapter extends ArrayAdapter<RunOffer> {
    public RunOffersAdapter(Context context, int listViewResourceId, int textViewResourceId, List<RunOffer> requests) {
        super(context, listViewResourceId, textViewResourceId, requests);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView row = (TextView) super.getView(position, convertView, parent);

        RunOffer req = getItem(position);

        row.setText(DatePresenter.presentRunDate(req, getContext()));

        return row;
    }
}