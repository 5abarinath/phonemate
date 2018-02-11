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
 * Created by sabari on 28/1/18.
 */

public class HomeFragment extends Fragment {
    private HomeFragment.OnFragmentInteractionListener mListener;
    private Smartphone[] top5Dataset, featuredDataset, newDataset;

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
        RecyclerView mRecyclerView = (RecyclerView) fragment.findViewById(R.id.recycler_view_top5);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //TODO retrofit
        top5Dataset = new Smartphone[5];
        for(int i=0; i<5; i++) {
            top5Dataset[i] = new Smartphone();
            top5Dataset[i].setThumbnail(getResources().getDrawable(R.drawable.oneplus5));
            top5Dataset[i].setDeviceName("One Plus 5");
        }
        featuredDataset = top5Dataset;
        newDataset = top5Dataset;

        MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(top5Dataset, false);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView = (RecyclerView) fragment.findViewById(R.id.recycler_view_featured);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(featuredDataset, false);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView = (RecyclerView) fragment.findViewById(R.id.recycler_view_new);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(newDataset, false);
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
