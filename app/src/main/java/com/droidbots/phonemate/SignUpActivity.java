package com.droidbots.phonemate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private EditText firstName, lastName, password, passwordConfirm;
    private AutoCompleteTextView email;
    private Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        password = findViewById(R.id.password);
        passwordConfirm = findViewById(R.id.passwordConfirm);
        email = findViewById(R.id.email);
        signupBtn = findViewById(R.id.signup_btn);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });
    }

    public void validateFields() {
        String fname = firstName.getText().toString();
        String lname = lastName.getText().toString();
        String emailVal = email.getText().toString();
        String pw1 = password.getText().toString();
        String pw2 = passwordConfirm.getText().toString();
        boolean errorFound = false;

        if(TextUtils.isEmpty(fname)) {
            firstName.setError(getString(R.string.error_field_required));
            errorFound = true;
        }
        if(TextUtils.isEmpty(lname)) {
            lastName.setError(getString(R.string.error_field_required));
            errorFound = true;
        }

        if (TextUtils.isEmpty(emailVal)) {
            email.setError(getString(R.string.error_field_required));
            errorFound = true;
        } else if (!isEmailValid(emailVal)) {
            email.setError(getString(R.string.error_invalid_email));
            errorFound = true;
        }

        if(TextUtils.isEmpty(pw1)) {
            password.setError(getString(R.string.error_field_required));
            errorFound = true;
        }
        else if(TextUtils.isEmpty(pw2)) {
            passwordConfirm.setError(getString(R.string.error_field_required));
            errorFound = true;
        }
        else if(pw1.length() < 6) {
            password.setError(getString(R.string.error_invalid_password));
            errorFound = true;
        }
        else if(!pw1.equals(pw2)){
            passwordConfirm.setError("Passwords do not match");
            errorFound = true;
        }

        if(!errorFound) {
            User user = new User(emailVal, pw1, fname, lname, null, null, null, null);
            initiateSignUp(user);
        }
    }

    private void initiateSignUp(User user) {
        APIService service = APIClient.getClient().create(APIService.class);
        Call<LoginMsg> call = service.registerUser(user);

        call.enqueue(new Callback<LoginMsg>() {
            @Override
            public void onResponse(Call<LoginMsg> call, Response<LoginMsg> response) {
                LoginMsg msg = response.body();
                if(msg.getStatus().equals("success")) {
                    Toast.makeText(getApplicationContext(), msg.getMsg(), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
                else {
                    Toast.makeText(getApplicationContext(), msg.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginMsg> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Check Internet connection", Toast.LENGTH_SHORT).show();
            }
        });
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
}
