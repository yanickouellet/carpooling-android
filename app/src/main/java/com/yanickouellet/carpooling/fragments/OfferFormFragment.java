package com.yanickouellet.carpooling.fragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.yanickouellet.carpooling.AppConstants;
import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.fragments.dialogs.DatePickerFragment;
import com.yanickouellet.carpooling.fragments.dialogs.TimePickerFragment;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import none.carpooling.Carpooling;
import none.carpooling.model.RunOffer;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class OfferFormFragment extends RoboFragment implements
        TimePickerFragment.OnTimeSetListener,
        DatePickerFragment.OnDateSetListener {

    private OnFragmentListener mListener;
    private RunOffer mCurrentOffer;
    private @InjectView(R.id.offer_form_to_address) EditText mToAddress;
    private @InjectView(R.id.offer_form_from_address) EditText mFromAddress;
    private @InjectView(R.id.offer_form_places) EditText mPlaces;
    private @InjectView(R.id.offer_form_km_value) EditText mKmValue;
    private @InjectView(R.id.offer_form_day_spinner) Spinner mDaySpinner;
    private @InjectView(R.id.offer_form_choose_time) Button mChooseTime;
    private @InjectView(R.id.offer_form_choose_date) Button mChooseDate;
    private @InjectView(R.id.offer_form_save) Button mSave;
    private @InjectView(R.id.offer_form_chk_ponctual) CheckBox mChkPonctual;

    public OfferFormFragment() {
        mCurrentOffer = new RunOffer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_offer_form, container, false);
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
        mCurrentOffer.setHour((long)hourOfDay);
        mCurrentOffer.setMinute((long)minute);

        mChooseTime.setText(String.format("%02dH%02d", hourOfDay, minute));
    }

    @Override
    public void onDateSet(GregorianCalendar date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        mCurrentOffer.setDate(fmt.format(date.getTime()));

        mChooseDate.setText(mCurrentOffer.getDate());
    }

    public interface OnFragmentListener {
        void onOfferCreated(RunOffer offer);
    }

    private boolean validate() {
        boolean valid = true;

        View focusView = null;

        if (mKmValue.getText().length() <= 0) {
            mKmValue.setError(getString(R.string.error_field_required));
            focusView = mKmValue;
            valid = false;
        }

        if (mPlaces.getText().length() <= 0) {
            mPlaces.setError(getString(R.string.error_field_required));
            focusView = mPlaces;
            valid = false;
        }

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

        if (mChkPonctual.isChecked() && mCurrentOffer.getDate() == null) {
            Toast.makeText(getActivity(), R.string.date_required, Toast.LENGTH_LONG).show();
            valid = false;
        }
        if(mCurrentOffer.getHour() == null || mCurrentOffer.getMinute() == null) {
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
            mCurrentOffer.setFromAddress(mFromAddress.getText().toString());
            mCurrentOffer.setToAddress(mToAddress.getText().toString());
            mCurrentOffer.setPonctual(mChkPonctual.isChecked());
            mCurrentOffer.setPlaces(Long.parseLong(mPlaces.getText().toString()));
            mCurrentOffer.setKmValue(Long.parseLong(mKmValue.getText().toString()));

            if (!mCurrentOffer.getPonctual()) {
                mCurrentOffer.setDayOfWeek((long)mDaySpinner.getSelectedItemPosition());
                mCurrentOffer.setDate(null);
            }

            new SaveOfferTask().execute(mCurrentOffer);
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

    private class SaveOfferTask extends AsyncTask<RunOffer, Void, RunOffer> {

        @Override
        protected RunOffer doInBackground(RunOffer... params) {
            RunOffer offer = params[0];

            Carpooling api = AppConstants.getApiServiceHandle();

            try {
                return api.runoffer().insert(offer).execute();
            } catch (IOException ex) {
                Log.e("API", "Exception during api call", ex);
            }

            return null;
        }

        @Override
        protected void onPostExecute(RunOffer offer) {
            if(offer != null) {
                mListener.onOfferCreated(offer);
            } else {
                Toast.makeText(getActivity(), getActivity().getString(R.string.invalid_address), Toast.LENGTH_LONG).show();
            }
        }
    }

}
