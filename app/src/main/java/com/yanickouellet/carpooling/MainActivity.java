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
        ProfileFragment.ProfileFragmentListener,
        RequestFormFragment.RequestFormFragmentListener,
        RunRequestListFragment.OnRunRequestsListFragmentListener {

    private @InjectResource(R.array.app_menu) String[] mMenuTitles;
    private @InjectView(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    private @InjectView(R.id.left_drawer) ListView mDrawerList;
    private @InjectView(R.id.toolbar) Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToolbar.setLogo(R.drawable.ic_drawer);
        setSupportActionBar(mToolbar);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListenet());

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestCreated(RunRequest request) {
        RunRequestDataSource ds = new RunRequestDataSource(this);
        ds.InsertRunRequest(request);

        LoadProfileFragment();
        Toast.makeText(this, R.string.run_request_saved, Toast.LENGTH_LONG).show();
    }

    private void LoadProfileFragment() {
        LoadFragment(new ProfileFragment());
    }

    private void LoadRequestFormFragment() {
        LoadFragment(new RequestFormFragment());
    }

    private void LoadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null) //TODO Not do that on load
                .commit();
    }

    private void LoadRequestListFragment() {
        LoadFragment(new RunRequestListFragment());
    }

    private class DrawerItemClickListenet implements ListView.OnItemClickListener {
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
