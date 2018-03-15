package com.droidbots.phonemate;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sabari on 15/3/18.
 */

public class FirstScreenFragment extends Fragment {
    private FirstScreenFragment.OnFragmentInteractionListener mListener;
    private Button btn_home, btn_recommend, btn_settings;

    public FirstScreenFragment() {
        // Required empty public constructor
    }
    public static FirstScreenFragment newInstance() {
        FirstScreenFragment fragment = new FirstScreenFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((OnFragmentInteractionListener) getActivity()).onFragmentInteraction(R.id.nav_home);
        View fragment = inflater.inflate(R.layout.fragment_firstpage, container, false);
        btn_home = fragment.findViewById(R.id.browse_btn);
        btn_recommend = fragment.findViewById(R.id.recommend_btn);
        btn_settings = fragment.findViewById(R.id.settings_btn);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_home, HomeFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_home, SettingsFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btn_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_home, QuestionnaireFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FirstScreenFragment.OnFragmentInteractionListener) {
            mListener = (FirstScreenFragment.OnFragmentInteractionListener) context;
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
