package com.droidbots.phonemate;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionnaireFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionnaireFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionnaireFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Button nextPageBtn, skipBtn;
    private ViewPager pager;
    private TabLayout tabLayout;

    public QuestionnaireFragment() {
        // Required empty public constructor
    }

    public static QuestionnaireFragment newInstance() {
        QuestionnaireFragment fragment = new QuestionnaireFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //TODO handle onBackPressed for viewpager

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_questionnaire, container, false);

        ((OnFragmentInteractionListener) getActivity()).onFragmentInteraction(R.id.nav_questionnaire);

        pager = (ViewPager) result.findViewById(R.id.pagerName);
        pager.setAdapter(buildAdapter());

        tabLayout = (TabLayout) result.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager, true);

        nextPageBtn = (Button) result.findViewById(R.id.btnNext);
        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pager.getCurrentItem() < 9)
                    pager.setCurrentItem(pager.getCurrentItem() + 1, true);
                else {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_home, RecommendationFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        skipBtn = (Button) result.findViewById(R.id.btnSkip);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        return result;
    }

    private PagerAdapter buildAdapter() {
        return(new QuestionSlidePagerAdapter(getChildFragmentManager()));
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
