package com.yanickouellet.carpooling.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.presenters.DatePresenter;

import java.util.List;

import none.carpooling.model.RunRequest;

public class RunRequestsAdapter extends ArrayAdapter<RunRequest> {
    public RunRequestsAdapter(Context context, int listViewResourceId, int textViewResourceId, List<RunRequest> requests) {
        super(context, listViewResourceId, textViewResourceId, requests);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView row = (TextView) super.getView(position, convertView, parent);

        RunRequest req = getItem(position);

        String matched = req.getMatched() ? " (" + getContext().getString(R.string.match_found) + ")" : "";
        row.setText(DatePresenter.presentRequestDate(req, getContext()) + matched);

        return row;
    }
}
