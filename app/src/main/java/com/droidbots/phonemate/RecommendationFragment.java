package com.droidbots.phonemate;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


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
    private Smartphone[] recommendedDataset;

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
        RecyclerView mRecyclerView = (RecyclerView) fragment.findViewById(R.id.recycler_view_recommend);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        recommendedDataset = new Smartphone[5];
        for(int i=0; i<5; i++) {
            recommendedDataset[i] = new Smartphone();
            recommendedDataset[i].setThumbnail(getResources().getDrawable(R.drawable.oneplus5));
            recommendedDataset[i].setDeviceName("One Plus 5");
            recommendedDataset[i].setPrice(String.valueOf(10000 * i));
        }
        MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(recommendedDataset, true);
        mRecyclerView.setAdapter(mAdapter);
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
