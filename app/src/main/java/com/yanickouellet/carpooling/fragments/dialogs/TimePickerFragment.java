package com.yanickouellet.carpooling.fragments.dialogs;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.yanickouellet.carpooling.R;

import java.util.Calendar;

import roboguice.fragment.RoboDialogFragment;

public class TimePickerFragment extends RoboDialogFragment implements TimePickerDialog.OnTimeSetListener {
    private TimePickerFragmentListener mListener;

    public TimePickerFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        attachListener();

        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    private void attachListener() {
        mListener = (TimePickerFragmentListener) getParentFragment();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mListener.onTimeSet(hourOfDay, minute);
    }

    public interface TimePickerFragmentListener {
        void onTimeSet(int hourOfDay, int minute);
    }
}