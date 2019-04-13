package com.example.lford.coollegeapp_levy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class ApplicantActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //-----------------------------------------------------------------------------------------
    Fragment contentFragment = null;
    final String APP_ID = getString(R.string.APP_ID);
    final String API_KEY = getString(R.string.API_KEY);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Backendless.initApp (this, APP_ID, API_KEY);


        BackendlessUser user = new BackendlessUser();
        user.setEmail("levyf2001@gmail.com");
        user.setPassword("password1");

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>(){
            @Override
            public void handleResponse(BackendlessUser backendlessUser){
                Log.i( "User ", backendlessUser.getEmail() + " successfully registered" );
            }
            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                Log.e( "Bckndlss rgstrtn rrr!", backendlessFault.getMessage());
            }
        });


        Object mProfile;
        Backendless.Data.of(Profile.class).save(mProfile, new AsyncCallback<Profile>() {
            @Override
            public void handleResponse(Profile response) {
                //Log.i(TAG, "Saved profile to Backendless");
            }
            public void handleFault(BackendlessFault fault) {
                //Log.i(TAG, "Failed to save profile!" + fault.getMessage());
            }
        });


        SharedPreferences sharedPreferences =
                this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMAIL_PREF, MY_EMAIL_ADDRESS);
        editor.commit();

        SharedPreferences sharedPreferences =
                getActivity().getPreferences(Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(ApplicantActivity.EMAIL_PREF, null);
        if (mProfile.getEmail() == null) {
            mProfile.setEmail(email);
        }


        String whereClause = "email = '" + email + "'";
        DataQueryBuilder query = DataQueryBuilder.create();
        query.setWhereClause(whereClause);
        Backendless.Data.of(Profile.class).find(query, new AsyncCallback<List<Profile>>() {
            @Override
            public void handleResponse(List<Profile> profile) {
                if (!profile.isEmpty()) {
                    String profileId = profile.get(0).getObjectId();
                    //Log.d(TAG, "Object ID: " + profileId);
                    mProfile.setObjectId(profileId);
                }
            }
            @Override
            public void handleFault(BackendlessFault fault) {
                //Log.e(TAG, "Failed to find profile: " + fault.getMessage());
            }
        });
        //--------------------------------------------------------------------------------
        setContentView(R.layout.activity_applicant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
//------------------------------------------------------------------------------------------------
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//------------------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
//------------------------------------------------------------------------------------------------
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
//-------------------------------------------------------------------------------------------------
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.family_member) {
            contentFragment = new FamilyListFragment();
        } else if (id == R.id.profile) {
            contentFragment = new ProfileFragment();
        }
        if (contentFragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, contentFragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}