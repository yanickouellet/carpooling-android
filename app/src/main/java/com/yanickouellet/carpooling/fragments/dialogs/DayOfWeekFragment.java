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

public class DayOfWeekFragment extends RoboDialogFragment {


    public DayOfWeekFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.day_of_week)
               .setItems(R.array.days_of_week, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }
}