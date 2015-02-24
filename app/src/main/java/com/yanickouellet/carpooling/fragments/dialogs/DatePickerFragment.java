package com.yanickouellet.carpooling.fragments.dialogs;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import roboguice.fragment.RoboDialogFragment;

public class DatePickerFragment extends RoboDialogFragment implements DatePickerDialog.OnDateSetListener {
    private OnDateSetListener mListener;

    public DatePickerFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        attachListener();

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    private void attachListener() {
        mListener = (OnDateSetListener) getParentFragment();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        GregorianCalendar date = new GregorianCalendar(year, monthOfYear, dayOfMonth);
        mListener.onDateSet(date);
    }

    public interface OnDateSetListener {
        void onDateSet(GregorianCalendar date);
    }
}