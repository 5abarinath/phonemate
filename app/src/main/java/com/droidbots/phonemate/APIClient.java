package com.droidbots.phonemate;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vishvanatarajan on 8/2/18.
 */

public class APIClient {
    private static Retrofit retrofit = null;
    private static String baseUrl;
    private static String type; //1=top5, 2=featured, 3=new, 4=recommendations
    private static List<Phone> respDevices;

    public void setupClient() {
        baseUrl = "http://192.168.1.34:5000/";
        type = "phones/featured";
    }

    public void setupClient(String url, int mType) {
        baseUrl = url;

        if(mType == 1)
            type = "phone/featured";
    }

    public List<Phone> getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Log.d("JSON", "helloinside");
            APIService service = retrofit.create(APIService.class);

            Call<List<Phone>> call = service.getDevices1();
            Log.d("hello", "getClient: ");
            call.enqueue(new Callback<List<Phone>>() {
                @Override
                public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
//                    Log.d("hello", response.body().get(0).getPhone()[0]);
                    Log.d("hello", response.body().get(0).getName());
                    respDevices = response.body();
                }

                @Override
                public void onFailure(Call<List<Phone>> call, Throwable t) {

                }
            });
//            call.enqueue(new Callback<List<Smartphone>>() {
//                @Override
//                public void onResponse(Call<List<Smartphone>> call, Response<List<Smartphone>> response) {
//                    Log.d("hello", "YOU ARE STILL A FAILURE");
//                    Log.d("hello", response.toString());
//                    respDevices = response.body();
//                }
//
//                @Override
//                public void onFailure(Call<List<Smartphone>> call, Throwable t) {
////                    respDevices.get(0).setStatus("FAILED");
//                    Log.d("hello", "YOU ARE A FAILURE");
//                }
//            });
        }
        return respDevices;
    }
}
