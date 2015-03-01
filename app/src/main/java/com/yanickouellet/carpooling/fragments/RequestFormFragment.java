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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

    private OnFragmentListener mListener;
    private RunRequest mCurrentRequest;
    private @InjectView(R.id.request_form_to_address) EditText mToAddress;
    private @InjectView(R.id.request_form_from_address) EditText mFromAddress;
    private @InjectView(R.id.request_form_day_spinner) Spinner mDaySpinner;
    private @InjectView(R.id.request_form_choose_time) Button mChooseTime;
    private @InjectView(R.id.request_form_choose_date) Button mChooseDate;
    private @InjectView(R.id.request_form_save) Button mSave;
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
            mListener = (OnFragmentListener) activity;
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

    public interface OnFragmentListener {
        void onRequestCreated(RunRequest request);
    }

    private boolean validate() {
        boolean valid = true;

        View focusView = null;

        if (mToAddress.getText().length() <= 5) {
            mToAddress.setError(getString(R.string.error_field_required));
            focusView = mToAddress;
            valid = false;
        }

        if (mFromAddress.getText().length() <= 5) {
            mToAddress.setError(getString(R.string.error_field_required));
            focusView = mFromAddress;
            valid = false;
        }

        if (mChkPonctual.isChecked() && mCurrentRequest.getDate() == null) {
            Toast.makeText(getActivity(), R.string.date_required, Toast.LENGTH_LONG).show();
            valid = false;
        }
        if(mCurrentRequest.getHour() == 0 && mCurrentRequest.getMinute() == 0) {
            Toast.makeText(getActivity(), R.string.time_required, Toast.LENGTH_LONG).show();
            valid = false;
        }

        if (!valid && focusView != null) {
            focusView.requestFocus();
        }

        return valid;
    }

    private void attemptToSave()
    {
        if (validate()) {
            mCurrentRequest.setFromAddress(mFromAddress.getText().toString());
            mCurrentRequest.setToAddress(mFromAddress.getText().toString());
            mCurrentRequest.setPoncutal(mChkPonctual.isChecked());;

            if (!mCurrentRequest.isPoncutal()) {
                mCurrentRequest.setDayOfWeek(mDaySpinner.getSelectedItemPosition());
                mCurrentRequest.setDate(null);
            }

            mListener.onRequestCreated(mCurrentRequest);
        }
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
        mSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                attemptToSave();
            }
        });
    }

}
