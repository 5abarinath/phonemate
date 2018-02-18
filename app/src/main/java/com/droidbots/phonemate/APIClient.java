package com.droidbots.phonemate;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vishvanatarajan on 8/2/18.
 */

public class APIClient {
    private static Retrofit retrofit = null;
    private static String baseUrl = "http://127.0.0.1:5000/";

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
