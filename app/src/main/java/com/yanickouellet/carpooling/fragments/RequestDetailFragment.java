package com.yanickouellet.carpooling.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.presenters.DatePresenter;

import none.carpooling.model.RunRequest;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class RequestDetailFragment extends RoboFragment {

    private RunRequest mRequest;

    private @InjectView(R.id.request_detail_from_address) TextView mFromAddress;
    private @InjectView(R.id.request_detail_to_address) TextView mToAddress;
    private @InjectView(R.id.request_detail_is_ponctual) TextView mIsPonctual;
    private @InjectView(R.id.request_detail_date) TextView mDate;
    private @InjectView(R.id.request_detail_state) TextView mState;

    public RequestDetailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRequest = (RunRequest) getArguments().getSerializable("request");

        return inflater.inflate(R.layout.fragment_request_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFromAddress.setText(mRequest.getFromAddress());
        mToAddress.setText(mRequest.getToAddress());
        mIsPonctual.setText(mRequest.getPonctual() ? R.string.yes : R.string.no);
        mDate.setText(DatePresenter.presentRequestDate(mRequest, getActivity()));
        mState.setText(mRequest.getMatched() ? getString(R.string.yes) : getString(R.string.no));
    }
}
