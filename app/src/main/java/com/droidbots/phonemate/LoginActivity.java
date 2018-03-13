package com.droidbots.phonemate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements OnClickListener {

    /**
     * Id to identity RC_SIGN_IN to retrieve result of the activity in onActivityResult()
     */
    private static final int RC_SIGN_IN = 1;
    private static final String TAG = "Failed Google Sign in";

    private GoogleSignInClient mGoogleSignInClient = null;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private TextView newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = findViewById(R.id.email);
        newUser = findViewById(R.id.prompt_sign_up);

        newUser.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });

        mPasswordView = findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id))
                .requestEmail()
                .requestProfile()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        findViewById(R.id.google_sign_in_button).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences mSharedPreference = getSharedPreferences("login_pref", MODE_PRIVATE);
        String token = mSharedPreference.getString("token", null);
        if(token == null)
            return;
        else
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }

    @SuppressLint("ShowToast")
    private void updateUI(GoogleSignInAccount account) {
        showProgress(false);
        if(account != null) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Could not sign in using Google account. Please try again", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Callback received when google sign in permission request has been completed
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            final GoogleSignInAccount account = task.getResult(ApiException.class);
            final String idToken = account.getIdToken();
            String email = account.getEmail();
            String[] firstName = account.getDisplayName().split(" ", 2);
            String lastName = account.getFamilyName();

            APIService service = APIClient.getClient().create(APIService.class);
            User user = new User(email, null, firstName[0], lastName);
            Call<LoginMsg> loginCall = service.validateGoogleSignIn(user, idToken);

            loginCall.enqueue(new Callback<LoginMsg>() {
                @Override
                public void onResponse(Call<LoginMsg> call, Response<LoginMsg> response) {
                    if(response.body().getStatus().equals("success")) {
                        SharedPreferences.Editor mSharedPreferenceEditor = getSharedPreferences("login_pref", MODE_PRIVATE).edit();
                        mSharedPreferenceEditor.putInt("loginMethod", 1);
                        mSharedPreferenceEditor.putString("token", response.body().getToken());
                        mSharedPreferenceEditor.putString("idToken", idToken);
                        mSharedPreferenceEditor.apply();
                        // Signed in successfully, show authenticated UI.
                        updateUI(account);
                    } else {
                        showProgress(false);
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<LoginMsg> call, Throwable t) {
                    showProgress(false);
                    Toast.makeText(getApplicationContext(), "Could not connect to server. Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
            });
        } catch(ApiException apiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + apiException.getStatusCode());
            updateUI(null);
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            doLogin(email, password);
        }
    }

    private boolean isEmailValid(String email) {
        boolean valid = false;
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
            valid = true;
        return valid;
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 6;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

        mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            }
        });

        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mProgressView.animate().setDuration(shortAnimTime).alpha(
                show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.google_sign_in_button:
                signInWithGoogle();
                break;
        }
    }

    private void signInWithGoogle() {
        showProgress(true);
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void doLogin(String email, String password) {

        APIService service = APIClient.getClient().create(APIService.class);

        User user = new User(email, password, null, null);
        Call<LoginMsg> loginCall = service.validateLogin(user);

        loginCall.enqueue(new Callback<LoginMsg>() {
            @Override
            public void onResponse(Call<LoginMsg> call, Response<LoginMsg> response) {
                showProgress(false);
                if(response.body().getStatus().equals("success")) {
                    SharedPreferences.Editor mSharedPreferenceEditor = getSharedPreferences("login_pref", MODE_PRIVATE).edit();
                    mSharedPreferenceEditor.putInt("loginMethod", 0);
                    mSharedPreferenceEditor.putString("token", response.body().getToken());
                    mSharedPreferenceEditor.apply();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginMsg> call, Throwable t) {
                showProgress(false);
                Toast.makeText(getApplicationContext(), "Could not connect to server. Please check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

