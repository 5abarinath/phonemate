package com.droidbots.phonemate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by vishvanatarajan on 8/2/18.
 */

public interface APIService {
    @POST("users/login/google")
    Call<List<LoginMsg>> validateGoogleSignIn();

    @Headers("Content-Type: application/json")
    @GET("phones/featured")
    Call<List<Smartphone>> getDevices();

    @Headers("Content-Type: application/json")
    @GET("phones/featured")
    Call<List<Phone>> getDevices1();
}
