package com.droidbots.phonemate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by vishvanatarajan on 8/2/18.
 */

public interface APIService {
    @POST("users/login/google")
    Call<List<LoginMsg>> validateGoogleSignIn();
}
