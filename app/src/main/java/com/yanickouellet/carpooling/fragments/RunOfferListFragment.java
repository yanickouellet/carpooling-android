package com.yanickouellet.carpooling.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.adapters.RunOffersAdapter;
import com.yanickouellet.carpooling.models.RunOffer;
import com.yanickouellet.carpooling.storage.RunOfferDataSource;

import java.util.ArrayList;

import roboguice.fragment.RoboFragment;

public class RunOfferListFragment extends RoboFragment implements AbsListView.OnItemClickListener {

    private OnFragmentListener mListener;

    private AbsListView mListView;
    private ListAdapter mAdapter;
    private ArrayList<RunOffer> mOffers;

    public RunOfferListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RunOfferDataSource RunOfferDataSource = new RunOfferDataSource(getActivity());
        mOffers = RunOfferDataSource.FetchAll();

        mAdapter = new RunOffersAdapter(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, mOffers);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_runoffer_list, container, false);


        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setEmptyView(view.findViewById(android.R.id.empty));
        setEmptyText(getString(R.string.no_offer));
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mListener.onRunOfferSelected(mOffers.get(position));
    }

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    public interface OnFragmentListener {
        public void onRunOfferSelected(RunOffer offer);
    }

}
