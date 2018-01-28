package com.droidbots.phonemate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sabari on 27/1/18.
 */

public class QuestionSlideFragment extends Fragment {
    private int mPageNumber;
    private TextView tv_questionTitle;

    public QuestionSlideFragment() {
    }

    public static QuestionSlideFragment create(int pageNumber) {
        QuestionSlideFragment fragment = new QuestionSlideFragment();
        Bundle args = new Bundle();
        args.putInt("page", pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt("page");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_question_viewpager, container, false);

        tv_questionTitle = (TextView) rootView.findViewById(R.id.questionTitle);
        tv_questionTitle.append(" - " + (mPageNumber + 1));
        return rootView;
    }
}
