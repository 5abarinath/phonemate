package com.droidbots.phonemate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sabari on 28/1/18.
 */

public class HomeFragment extends Fragment {
    private HomeFragment.OnFragmentInteractionListener mListener;
    private List<Phone> top5Dataset;
    private List<Phone> featuredDataset;
    private List<Phone> newDataset;

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_home, container, false);
        final RecyclerView mRecyclerViewTop = (RecyclerView) fragment.findViewById(R.id.recycler_view_top5);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewTop.setLayoutManager(mLayoutManager);

        APIService service = APIClient.getClient().create(APIService.class);
        Call<List<Phone>> call = service.getTopDevices();
        Log.d("Sabari", "onCreateView: Before retrofit call");
        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                top5Dataset = response.body();
                Log.d("Sabari", "YOLO");
                Log.d("Sabari", top5Dataset.get(0).getName());
                MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(getActivity(), top5Dataset,
                        new MyRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Phone smartphone) {
                        Log.d("CLICKED", smartphone.getName());
                        Intent intent = new Intent(getActivity(), SmartphoneActivity.class);
                        intent.putExtra("smartphone", smartphone);
                        startActivity(intent);
                    }
                }, false);
                mRecyclerViewTop.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {
                Log.d("Sabari", "You are a failure");
            }
        });

        final RecyclerView mRecyclerViewFeatured = (RecyclerView) fragment.findViewById(R.id.recycler_view_featured);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewFeatured.setLayoutManager(mLayoutManager);

        service = APIClient.getClient().create(APIService.class);
        call = service.getFeaturedDevices();
        Log.d("Sabari", "onCreateView: Before retrofit call");
        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                featuredDataset = response.body();
                Log.d("Sabari", "YOLO");
                Log.d("Sabari", featuredDataset.get(0).getName());
                MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(getActivity(), featuredDataset, new MyRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Phone smartphone) {
                        Log.d("CLICKED", smartphone.getName());
                        Intent intent = new Intent(getActivity(), SmartphoneActivity.class);
                        intent.putExtra("smartphone", smartphone);
                        startActivity(intent);
                    }
                }, false);
                mRecyclerViewFeatured.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {
                Log.d("Sabari", "You are a failure");
            }
        });

        final RecyclerView mRecyclerViewNew = (RecyclerView) fragment.findViewById(R.id.recycler_view_new);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewNew.setLayoutManager(mLayoutManager);

        service = APIClient.getClient().create(APIService.class);
        call = service.getNewDevices();
        Log.d("Sabari", "onCreateView: Before retrofit call");
        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                newDataset = response.body();
                Log.d("Sabari", "YOLO");
                Log.d("Sabari", newDataset.get(0).getName());
                MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(getActivity(), newDataset, new MyRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Phone smartphone) {
                        Log.d("CLICKED", smartphone.getName());
                        Intent intent = new Intent(getActivity(), SmartphoneActivity.class);
                        intent.putExtra("smartphone", smartphone);
                        startActivity(intent);
                    }
                }, false);
                mRecyclerViewNew.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {
                Log.d("Sabari", "You are a failure");
            }
        });

//        mRecyclerView = (RecyclerView) fragment.findViewById(R.id.recycler_view_featured);
//        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new MyRecyclerViewAdapter(featuredDataset, new MyRecyclerViewAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Phone smartphone) {
//                Log.d("CLICKED", smartphone.getName());
//            }
//        }, false);
//        mRecyclerView.setAdapter(mAdapter);
//
//        mRecyclerView = (RecyclerView) fragment.findViewById(R.id.recycler_view_new);
//        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new MyRecyclerViewAdapter(newDataset, new MyRecyclerViewAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Phone smartphone) {
//                Log.d("CLICKED", smartphone.getName());
//            }
//        }, false);
//        mRecyclerView.setAdapter(mAdapter);
        return fragment;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof HomeFragment.OnFragmentInteractionListener) {
            mListener = (HomeFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
