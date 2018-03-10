package com.droidbots.phonemate;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by vishvanatarajan on 8/2/18.
 */

public interface APIService {
    @Headers("Content-Type: application/json")
    @POST("users/login")
    Call<LoginMsg> validateLogin(@Body User user);

    @Headers("Content-Type: application/json")
    @POST("users/login/google")
    Call<LoginMsg> validateGoogleSignIn(@Body User user, @Header("Authorization") String idToken);

    @Headers("Content-Type: application/json")
    @POST("users/google/logout")
    Call<LogoutMSG> performGoogleSignOut(@Header("Authorization") String idToken);
}
