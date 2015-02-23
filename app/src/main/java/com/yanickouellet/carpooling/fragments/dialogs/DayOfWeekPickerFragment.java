package com.yanickouellet.carpooling.fragments.dialogs;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import com.yanickouellet.carpooling.R;

import java.util.Calendar;

import roboguice.fragment.RoboDialogFragment;

public class DayOfWeekPickerFragment extends RoboDialogFragment {
    private OnDayPickedListener mListener;

    public DayOfWeekPickerFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        attachListener();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.day_of_week)
               .setItems(R.array.days_of_week, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDayPicked(which);
                    }
                });

        return builder.create();
    }

    private void attachListener() {
        mListener = (OnDayPickedListener) getParentFragment();
    }

    public interface OnDayPickedListener {
        void onDayPicked(int dayOfWeek);
    }
}