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

import com.yanickouellet.carpooling.adapters.RunRequestsAdapter;
import com.yanickouellet.carpooling.models.RunRequest;
import com.yanickouellet.carpooling.storage.RunRequestDataSource;

import java.util.ArrayList;

import roboguice.fragment.RoboFragment;

public class RunRequestListFragment extends RoboFragment implements AbsListView.OnItemClickListener {

    private OnFragmentListener mListener;

    private AbsListView mListView;
    private ListAdapter mAdapter;
    private ArrayList<RunRequest> mRequests;

    public RunRequestListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RunRequestDataSource runRequestDataSource = new RunRequestDataSource(getActivity());
        mRequests = runRequestDataSource.FetchAll();

        mAdapter = new RunRequestsAdapter(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, mRequests);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_runrequest, container, false);


        mListView = (AbsListView) view.findViewById(android.R.id.list);
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
        mListener.OnRunRequestSelected(mRequests.get(position));
    }

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    public interface OnFragmentListener {
        public void OnRunRequestSelected(RunRequest request);
    }

}