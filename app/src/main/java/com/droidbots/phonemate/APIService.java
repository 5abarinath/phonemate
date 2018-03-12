package com.droidbots.phonemate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
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

    @Headers("Content-Type: application/json")
    @GET("phones/featured")
    Call<List<Phone>> getFeaturedDevices();

    @Headers("Content-Type: application/json")
    @GET("phones/top5")
    Call<List<Phone>> getTopDevices();

    @Headers("Content-Type: application/json")
    @GET("phones/new")
    Call<List<Phone>> getNewDevices();
}
