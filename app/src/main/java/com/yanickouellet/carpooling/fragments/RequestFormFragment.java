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
import android.widget.CheckBox;
import android.widget.Spinner;

import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.fragments.dialogs.DatePickerFragment;
import com.yanickouellet.carpooling.fragments.dialogs.TimePickerFragment;
import com.yanickouellet.carpooling.models.RunRequest;

import java.util.GregorianCalendar;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class RequestFormFragment extends RoboFragment implements
        TimePickerFragment.OnTimeSetListener,
        DatePickerFragment.OnDateSetListener {

    private RequestFormFragmentListener mListener;
    private RunRequest mCurrentRequest;
    private @InjectView(R.id.request_form_day_spinner) Spinner mDaySpinner;
    private @InjectView(R.id.request_form_choose_time) Button mChooseTime;
    private @InjectView(R.id.request_form_choose_date) Button mChooseDate;
    private @InjectView(R.id.request_form_chk_ponctual) CheckBox mChkPonctual;

    public RequestFormFragment() {
        mCurrentRequest = new RunRequest();
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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.days_of_week, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDaySpinner.setAdapter(adapter);

        super.onActivityCreated(savedInstanceState);
    }

    public void onChkPonctualClick() {
        if (mChkPonctual.isChecked()) {
            mChooseDate.setVisibility(View.VISIBLE);
            mDaySpinner.setVisibility(View.GONE);
        } else {
            mChooseDate.setVisibility(View.GONE);
            mDaySpinner.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onTimeSet(int hourOfDay, int minute) {
        mCurrentRequest.setHour(hourOfDay);
        mCurrentRequest.setMinute(minute);

        mChooseTime.setText(String.format("%02dH%02d", hourOfDay, minute));
    }

    @Override
    public void onDateSet(GregorianCalendar date) {
        mCurrentRequest.setDate(date);

        mChooseDate.setText(mCurrentRequest.getFormatedDate());
    }

    public interface RequestFormFragmentListener {
    }

    private void RegisterListeners() {
        mChooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new TimePickerFragment();
                fragment.show(getChildFragmentManager(), "timePicker");
            }
        });
        mChooseDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new DatePickerFragment();
                fragment.show(getChildFragmentManager(), "datePicker");
            }
        });
        mChkPonctual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onChkPonctualClick();
            }
        });
    }

}
