package com.yanickouellet.carpooling.fragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.yanickouellet.carpooling.AppConstants;
import com.yanickouellet.carpooling.R;
import com.yanickouellet.carpooling.adapters.RunOffersAdapter;
import com.yanickouellet.carpooling.storage.Serializer;

import java.io.IOException;
import java.util.ArrayList;

import none.carpooling.model.RunOffer;
import none.carpooling.model.RunOfferCollection;
import roboguice.fragment.RoboFragment;

public class RunOfferListFragment extends RoboFragment implements AbsListView.OnItemClickListener {

    private OnFragmentListener mListener;

    private AbsListView mListView;
    private RunOffersAdapter mAdapter;
    private ArrayList<RunOffer> mOffers;

    public RunOfferListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mOffers = new ArrayList<>();

        mAdapter = new RunOffersAdapter(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, mOffers);

        Serializer serializer = new Serializer(this.getActivity());
        Object obj =  serializer.readObject("offers.bin");
        if (obj != null) {
            mOffers.addAll((ArrayList<RunOffer>)obj);
        }
        mAdapter.notifyDataSetChanged();

        new DownloadOffersTask().execute();
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

    private class DownloadOffersTask extends AsyncTask<Void, Void, RunOfferCollection> {

        @Override
        protected RunOfferCollection doInBackground(Void... params) {
            try {
                return AppConstants.getApiServiceHandle().runoffer().list().execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(RunOfferCollection runOfferCollection) {
            if (runOfferCollection != null && runOfferCollection.getItems() != null) {
                mOffers.clear();
                mOffers.addAll(runOfferCollection.getItems());
                mAdapter.notifyDataSetChanged();

                Serializer serializer = new Serializer(RunOfferListFragment.this.getActivity());
                serializer.writeObject(mOffers, "offers.bin");
            }
        }
    }

}
