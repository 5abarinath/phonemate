package com.droidbots.phonemate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Map;

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

        ((OnFragmentInteractionListener) getActivity()).onFragmentInteraction(R.id.nav_recommendation);

        final RecyclerView mRecyclerView = (RecyclerView) fragment.findViewById(R.id.recycler_view_recommend);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        Log.e("WTF1", "LOREM IPSUM DOLOR AMET");
        SharedPreferences mSharedPref = getActivity().getSharedPreferences("userAnswers",
                Context.MODE_PRIVATE);
        Map<String, ?> userResponses1 = mSharedPref.getAll();
        for (Map.Entry<String, ?> entry : userResponses1.entrySet()) {
            Log.d("Sabari", "Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        String[] userResponses = new String[10];
        userResponses[0] = mSharedPref.getString("smartphone", "-1");
        userResponses[1] = mSharedPref.getString("os", "-1");
        userResponses[2] = mSharedPref.getString("price", "-1");
        userResponses[3] = mSharedPref.getString("busage", "-1");
        userResponses[4] = mSharedPref.getString("battery", "-1");
        userResponses[5] = mSharedPref.getString("storage", "-1");
        userResponses[6] = mSharedPref.getString("camera", "-1");
        userResponses[7] = mSharedPref.getString("screen", "-1");
        userResponses[8] = mSharedPref.getString("ram", "-1");
        userResponses[9] = mSharedPref.getString("weight", "-1");

        Log.e("WTF2", "LOREM IPSUM DOLOR AMET");
        APIService service = APIClient.getClient().create(APIService.class);
        Responses responses = new Responses(userResponses[0], userResponses[1],
                userResponses[2], userResponses[3], userResponses[4], userResponses[5],
                userResponses[6], userResponses[7], userResponses[8], userResponses[9]);
        Call<List<Phone>> call = service.getRecommendedDevices(responses);
        Log.e("WTF3", "LOREM IPSUM DOLOR AMET");
        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                recommendedDataset = response.body();
//                if(response.body().get(0).getStatus().equals("Failure")) {
//                    Log.d("NULL DATASET", "onResponse: kappa123");
//                    AlertDialog.Builder builder;
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
//                    } else {
//                        builder = new AlertDialog.Builder(getActivity());
//                    }
//                    builder.setTitle("Oops")
//                            .setMessage(recommendedDataset.get(0).getMessage())
//                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    // do nothing
//                                }
//                            })
//                            .show();
//                }
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
        Log.e("WTF3", "LOREM IPSUM DOLOR AMET");

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
        void onFragmentInteraction(int id);
    }
}
