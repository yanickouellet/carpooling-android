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

import com.yanickouellet.carpooling.adapters.RunRequestsAdapter;
import com.yanickouellet.carpooling.storage.Serializer;

import java.io.IOException;
import java.util.ArrayList;

import none.carpooling.model.RunRequest;
import none.carpooling.model.RunRequestCollection;
import roboguice.fragment.RoboFragment;

public class RunRequestListFragment extends RoboFragment implements AbsListView.OnItemClickListener {

    private OnFragmentListener mListener;

    private AbsListView mListView;
    private RunRequestsAdapter mAdapter;
    private ArrayList<RunRequest> mRequests;

    public RunRequestListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRequests = new ArrayList<>();

        mAdapter = new RunRequestsAdapter(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, mRequests);

        Serializer serializer = new Serializer(this.getActivity());
        Object obj =  serializer.readObject("requests.bin");
        if (obj != null) {
            mRequests.addAll((ArrayList<RunRequest>)obj);
        }
        mAdapter.notifyDataSetChanged();

        new DownloadRequestsTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_runrequest, container, false);


        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setEmptyView(view.findViewById(android.R.id.empty));
        setEmptyText(getString(R.string.no_request));
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
        mListener.onRunRequestSelected(mRequests.get(position));
    }

    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    public interface OnFragmentListener {
        public void onRunRequestSelected(RunRequest request);
    }

    private class DownloadRequestsTask extends AsyncTask<Void, Void, RunRequestCollection>{

        @Override
        protected RunRequestCollection doInBackground(Void... params) {
            try {
                return AppConstants.getApiServiceHandle().runrequest().list().execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(RunRequestCollection runRequestCollection) {
            if (runRequestCollection != null && runRequestCollection.getItems() != null) {
                mRequests.clear();
                mRequests.addAll(runRequestCollection.getItems());
                mAdapter.notifyDataSetChanged();

                Serializer serializer = new Serializer(RunRequestListFragment.this.getActivity());
                serializer.writeObject(mRequests, "requests.bin");
            }
        }
    }

}
