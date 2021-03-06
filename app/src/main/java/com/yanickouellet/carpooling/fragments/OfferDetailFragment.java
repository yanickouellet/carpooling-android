package com.yanickouellet.carpooling.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.presenters.DatePresenter;

import none.carpooling.model.RunOffer;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import roboguice.util.Strings;

public class OfferDetailFragment extends RoboFragment {

    private RunOffer mOffer;

    private @InjectView(R.id.offer_detail_from_address) TextView mFromAddress;
    private @InjectView(R.id.offer_detail_to_address) TextView mToAddress;
    private @InjectView(R.id.offer_detail_places) TextView mPlaces;
    private @InjectView(R.id.offer_detail_km_value) TextView mKmValue;
    private @InjectView(R.id.offer_detail_is_ponctual) TextView mIsPonctual;
    private @InjectView(R.id.offer_detail_date) TextView mDate;
    private @InjectView(R.id.offer_detail_state) TextView mState;
    private @InjectView(R.id.offer_detail_passenger) TextView mPassengers;

    public OfferDetailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mOffer = (RunOffer) getArguments().getSerializable("offer");

        return inflater.inflate(R.layout.fragment_offer_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFromAddress.setText(mOffer.getFromAddress());
        mToAddress.setText(mOffer.getToAddress());
        mPlaces.setText(Long.toString(mOffer.getPlaces()));
        mKmValue.setText(Long.toString(mOffer.getKmValue()));
        mIsPonctual.setText(mOffer.getPonctual() ? R.string.yes : R.string.no);
        mDate.setText(DatePresenter.presentOfferDate(mOffer, getActivity()));
        mState.setText(Long.toString(mOffer.getPlaces() - mOffer.getRemainingPlaces()) + " / " + mOffer.getPlaces().toString());
        mPassengers.setText(Strings.join("\n", mOffer.getPassengers()));
    }
}
