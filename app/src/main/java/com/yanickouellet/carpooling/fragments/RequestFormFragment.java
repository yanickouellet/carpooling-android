package com.yanickouellet.carpooling.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.fragments.dialogs.TimePickerFragment;
import com.yanickouellet.carpooling.models.RunRequest;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class RequestFormFragment extends RoboFragment implements
        TimePickerFragment.OnTimeSetListener {

    private RequestFormFragmentListener mListener;
    private RunRequest mCurrentRequest;
    private @InjectView(R.id.request_form_new_instance) Button mBtnNewInstance;
    private @InjectView(R.id.request_form_day_spinner) Spinner mDaySpinner;

    public RequestFormFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_request_form, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.days_of_week, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDaySpinner.setAdapter(adapter);
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
        mCurrentRequest.setHour(hourOfDay);
        mCurrentRequest.setMinute(minute);
    }

    public interface RequestFormFragmentListener {
    }

    private void showTimePickerDialog() {
        mCurrentRequest = new RunRequest();
        DialogFragment fragment = new TimePickerFragment();
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
