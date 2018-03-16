package com.droidbots.phonemate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, QuestionnaireFragment.OnFragmentInteractionListener,
        PrivacyFragment.OnFragmentInteractionListener, ProfileFragment.OnFragmentInteractionListener,
        RecommendationFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener,
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

        getProfileInfo();
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
    public void onResume() {
        super.onResume();
        getProfileInfo();
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
        Log.d("TAG HERE", "lol123");
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

    public Bitmap decodeBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public void getProfileInfo() {
        View headerView = navigationView.getHeaderView(0);
        final TextView navName = headerView.findViewById(R.id.nav_header_nameTextView);
        final TextView navEmail = headerView.findViewById(R.id.nav_header_emailTextView);
        final ImageView navProfilePic = headerView.findViewById(R.id.nav_header_imageView);
        SharedPreferences mSharedPreferences = getApplicationContext().getSharedPreferences("login_pref", Context.MODE_PRIVATE);
        String token = mSharedPreferences.getString("token", null);
        String profpic = mSharedPreferences.getString("profpic", null);
        boolean google = mSharedPreferences.getBoolean("googlePhoto", false);
        if(token == null) {
            Toast.makeText(getApplicationContext(), "Invalid login", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        }
        if(profpic == null || profpic == "")
            navProfilePic.setImageResource(getResources().getIdentifier("ic_launcher_round", "mipmap", getPackageName()));
        else {
            if(google) {
                Glide.with(this)
                        .load(profpic)
                        .asBitmap()
                        .placeholder(R.mipmap.ic_launcher_round)
                        .error(R.mipmap.ic_launcher_round)
                        .override(150, 150)
                        .centerCrop()
                        .into(new BitmapImageViewTarget(navProfilePic) {
                            @Override
                            protected void setResource(Bitmap resource) {
                                RoundedBitmapDrawable circularBitmapDrawable =
                                        RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource);
                                circularBitmapDrawable.setCircular(true);
                                navProfilePic.setImageDrawable(circularBitmapDrawable);
                            }
                        });
            } else {
                navProfilePic.setImageBitmap(decodeBase64(profpic));
            }
        }

        APIService service = APIClient.getClient().create(APIService.class);
        Call<User> navHeaderCall = service.getUserProfile(token);
        navHeaderCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                navName.setText(response.body().getName());
                navEmail.setText(response.body().getEmail());
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
