package com.droidbots.phonemate;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, QuestionnaireFragment.OnFragmentInteractionListener,
        PrivacyFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener,
        RecommendationFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener,
        FeedbackFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener{

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_home, HomeFragment.newInstance())
                .commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_home, QuestionnaireFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        int id = item.getItemId();
        navigationView.setCheckedItem(id);
        boolean isFragment = true;
        if (id == R.id.nav_home) {
            fragment = HomeFragment.newInstance();
            //TODO shared preference
        } else if (id == R.id.nav_profile) {
            fragment = ProfileFragment.newInstance();
        } else if (id == R.id.nav_recommendation) {
            fragment = RecommendationFragment.newInstance();
        } else if (id == R.id.nav_feedback) {
            fragment = FeedbackFragment.newInstance();
        } else if (id == R.id.nav_settings) {
            fragment = SettingsFragment.newInstance();
        } else if (id == R.id.nav_privacy) {
            fragment = PrivacyFragment.newInstance();
        }

        if(isFragment) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_home, fragment)
                    .commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
