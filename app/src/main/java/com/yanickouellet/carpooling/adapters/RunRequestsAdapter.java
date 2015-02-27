package com.yanickouellet.carpooling.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.models.RunRequest;

import java.util.Calendar;
import java.util.List;

public class RunRequestsAdapter extends ArrayAdapter<RunRequest> {
    public RunRequestsAdapter(Context context, int listViewResourceId, int textViewResourceId, List<RunRequest> requests) {
        super(context, listViewResourceId, textViewResourceId, requests);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView row = (TextView) super.getView(position, convertView, parent);

        RunRequest req = getItem(position);

        String text = "";

        if (req.isPoncutal()) {
            Calendar date = req.getDate();
            text += date.get(Calendar.DAY_OF_MONTH) + " " +
                    date.getDisplayName(Calendar.MONTH, Calendar.LONG, getContext().getResources().getConfiguration().locale);
        } else {
            text += getContext().getResources().getStringArray(R.array.days_of_week)[req.getDayOfWeek()];
        }

        text += " " + req.getHour() + "H" + req.getMinute();

        row.setText(text);

        return row;
    }
}
