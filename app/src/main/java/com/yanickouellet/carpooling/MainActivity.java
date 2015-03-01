package com.yanickouellet.carpooling;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.yanickouellet.carpooling.fragments.ProfileFragment;
import com.yanickouellet.carpooling.fragments.RequestDetailFragment;
import com.yanickouellet.carpooling.fragments.RequestFormFragment;
import com.yanickouellet.carpooling.fragments.RunRequestListFragment;
import com.yanickouellet.carpooling.models.RunRequest;
import com.yanickouellet.carpooling.storage.RunRequestDataSource;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActionBarActivity implements
        ProfileFragment.OnFragmentListener,
        RequestFormFragment.OnFragmentListener,
        RunRequestListFragment.OnFragmentListener {

    private @InjectResource(R.array.app_menu) String[] mMenuTitles;
    private @InjectView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    private @InjectView(R.id.left_drawer) ListView mDrawerList;
    private @InjectView(R.id.toolbar) Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mToolbar.setLogo(R.drawable.ic_drawer);
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
            LoadProfileFragment();
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

        LoadProfileFragment();
        Toast.makeText(this, R.string.run_request_saved, Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnRunRequestSelected(RunRequest request) {
        LoadRequestDetailFragment(request);
    }

    private void LoadProfileFragment() {
        LoadFragment(new ProfileFragment());
    }

    private void LoadRequestFormFragment() {
        LoadFragment(new RequestFormFragment());
    }

    private void LoadRequestDetailFragment(RunRequest request) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("request", request);

        RequestDetailFragment fragment = new RequestDetailFragment();
        fragment.setArguments(bundle);

        LoadFragment(fragment);
    }

    private void LoadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void LoadRequestListFragment() {
        LoadFragment(new RunRequestListFragment());
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
                LoadProfileFragment();
                break;
            case 1:
                LoadRequestFormFragment();
                break;
            case 2:
                LoadRequestListFragment();
                break;
        }

        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }
}
