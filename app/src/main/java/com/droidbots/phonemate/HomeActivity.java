package com.droidbots.phonemate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, QuestionnaireFragment.OnFragmentInteractionListener,
        PrivacyFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener,
        RecommendationFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener,
        FeedbackFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener,
        FirstScreenFragment.OnFragmentInteractionListener{

    NavigationView navigationView;
    SharedPreferences sharedPreferences;

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

        sharedPreferences = getPreferences(MODE_PRIVATE);
        boolean openingAppForTheFirstTime = sharedPreferences.getBoolean("openingAppForTheFirstTime", true);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //TODO create sharedPref only after closing questionnaireFragment
        editor.putBoolean("openingAppForTheFirstTime", false);
        editor.apply();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_home, FirstScreenFragment.newInstance())
                .commit();

        if(openingAppForTheFirstTime) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_home, QuestionnaireFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
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
            int loginMethod;
            final SharedPreferences mSharedPreference = getSharedPreferences("login_pref", MODE_PRIVATE);
            loginMethod = mSharedPreference.getInt("loginMethod", -1);
            if(loginMethod == 1) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.server_client_id))
                        .requestEmail()
                        .requestProfile()
                        .build();
                // Build a GoogleSignInClient with the options specified by gso.
                final GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
                mGoogleSignInClient.signOut()
                        .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                            }
                        });
            }
            SharedPreferences.Editor editor = mSharedPreference.edit();
            editor.clear();
            editor.apply();
            Toast.makeText(getApplicationContext(), R.string.action_sign_out, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("WTFWTF", "lol123");
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
        } else if (id == R.id.nav_questionnaire) {
            fragment = QuestionnaireFragment.newInstance();
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
    public void onFragmentInteraction(int id) {
        navigationView.setCheckedItem(id);
    }
}
