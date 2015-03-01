package com.yanickouellet.carpooling;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.yanickouellet.carpooling.fragments.OfferFormFragment;
import com.yanickouellet.carpooling.fragments.ProfileFragment;
import com.yanickouellet.carpooling.fragments.RequestDetailFragment;
import com.yanickouellet.carpooling.fragments.RequestFormFragment;
import com.yanickouellet.carpooling.fragments.RunRequestListFragment;
import com.yanickouellet.carpooling.models.RunOffer;
import com.yanickouellet.carpooling.models.RunRequest;
import com.yanickouellet.carpooling.storage.RunOfferDataSource;
import com.yanickouellet.carpooling.storage.RunRequestDataSource;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActionBarActivity implements
        ProfileFragment.OnFragmentListener,
        RequestFormFragment.OnFragmentListener,
        OfferFormFragment.OnFragmentListener,
        RunRequestListFragment.OnFragmentListener
        {

    private @InjectResource(R.array.app_menu) String[] mMenuTitles;
    private @InjectView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    private @InjectView(R.id.left_drawer) ListView mDrawerList;
    private @InjectView(R.id.toolbar) Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This do not seem to be necessary and, when active, it show a strange text in the middle
        // of the activity
        //setSupportActionBar(mToolbar);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        if (savedInstanceState == null) {
            loadProfileFragment();
        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onRequestCreated(RunRequest request) {
        RunRequestDataSource ds = new RunRequestDataSource(this);
        ds.InsertRunRequest(request);

        loadProfileFragment();
        Toast.makeText(this, R.string.run_request_saved, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onOfferCreated(RunOffer offer) {
        RunOfferDataSource ds = new RunOfferDataSource(this);
        ds.InsertRunOffer(offer);

        loadProfileFragment();
        Toast.makeText(this, R.string.run_offer_saved, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRunRequestSelected(RunRequest request) {
        loadRequestDetailFragment(request);
    }

    private void loadProfileFragment() {
        loadFragment(new ProfileFragment());
    }

    private void loadRequestFormFragment() {
        loadFragment(new RequestFormFragment());
    }

    private void loadRequestDetailFragment(RunRequest request) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("request", request);

        RequestDetailFragment fragment = new RequestDetailFragment();
        fragment.setArguments(bundle);

        loadFragment(fragment);
    }

    private void loadOfferFormFragment() {
        loadFragment(new OfferFormFragment());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void loadRequestListFragment() {
        loadFragment(new RunRequestListFragment());
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        switch (position) {
            case 0:
                loadProfileFragment();
                break;
            case 1:
                loadRequestFormFragment();
                break;
            case 2:
                loadRequestListFragment();
                break;
            case 3:
                loadOfferFormFragment();
                break;
        }

        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }
}
