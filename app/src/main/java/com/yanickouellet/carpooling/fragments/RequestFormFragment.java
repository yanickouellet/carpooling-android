package com.yanickouellet.carpooling.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.fragments.dialogs.DayOfWeekPickerFragment;
import com.yanickouellet.carpooling.fragments.dialogs.TimePickerFragment;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class RequestFormFragment extends RoboFragment implements
        TimePickerFragment.OnTimeSetListener,
        DayOfWeekPickerFragment.OnDayPickedListener {

    private RequestFormFragmentListener mListener;
    private @InjectView(R.id.request_form_new_instance) Button mBtnNewInstance;

    public RequestFormFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_form, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (RequestFormFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        RegisterListeners();

        super.onActivityCreated(savedInstanceState);
    }

    public void onNewInstanceClick() {
        showTimePickerDialog();
    }

    @Override
    public void onTimeSet(int hourOfDay, int minute) {
        Log.i("Time", Integer.toString(hourOfDay));
    }

    @Override
    public void onDayPicked(int dayOfWeek) {
        Log.i("Day", Integer.toString(dayOfWeek));
        DialogFragment fragment = new TimePickerFragment();
        fragment.show(getChildFragmentManager(), "timePicker");
    }

    public interface RequestFormFragmentListener {
    }

    private void showTimePickerDialog() {
        DialogFragment fragment = new DayOfWeekPickerFragment();
        fragment.show(getChildFragmentManager(), "dayOfWeekPicker");
    }

    private void RegisterListeners() {
        mBtnNewInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNewInstanceClick();
            }
        });
    }

}
