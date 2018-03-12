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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecommendationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecommendationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecommendationFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private List<Phone> recommendedDataset;

    public RecommendationFragment() {
        // Required empty public constructor
    }

    public static RecommendationFragment newInstance() {
        RecommendationFragment fragment = new RecommendationFragment();
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
        View fragment = inflater.inflate(R.layout.fragment_recommendation, container, false);

        final RecyclerView mRecyclerView = (RecyclerView) fragment.findViewById(R.id.recycler_view_recommend);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        APIService service = APIClient.getClient().create(APIService.class);
        Call<List<Phone>> call = service.getTopDevices();
        Log.d("Sabari", "onCreateView: Before retrofit call");
        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                recommendedDataset = response.body();
                Log.d("Sabari", "YOLO");
                Log.d("Sabari", recommendedDataset.get(0).getName());
                MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(getActivity(), recommendedDataset,
                        new MyRecyclerViewAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(Phone smartphone) {
                                Log.d("CLICKED", smartphone.getName());
                                Intent intent = new Intent(getActivity(), SmartphoneActivity.class);
                                intent.putExtra("smartphone", smartphone);
                                startActivity(intent);
                            }
                        }, true);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {
                Log.d("Sabari", "You are a failure");
            }
        });
//        RecyclerView mRecyclerView = (RecyclerView) fragment.findViewById(R.id.recycler_view_recommend);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(recommendedDataset, new MyRecyclerViewAdapter.OnItemClickListener() {
//           @Override
//           public void onItemClick(Phone smartphone) {
//               Log.d("CLICKED", smartphone.getName());
//               Intent intent = new Intent(getActivity(), SmartphoneActivity.class);
//               intent.putExtra("smartphone", smartphone);
//               startActivity(intent);
//           }
//        }, true);
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
