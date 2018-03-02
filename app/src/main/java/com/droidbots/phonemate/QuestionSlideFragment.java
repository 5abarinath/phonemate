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
	private TextView tv_questionTitle, tv_category, tv_option1, tv_option2, tv_option3, tv_option4;

	private static final int[] QUESTION_LOOKUP_TABLE = new int[] {
	        R.string.category0, R.string.question0,
            R.string.category1, R.string.question1,
            R.string.category2, R.string.question2,
            R.string.category3, R.string.question3,
            R.string.category4, R.string.question4,
            R.string.category5, R.string.question5,
            R.string.category6, R.string.question6,
            R.string.category7, R.string.question7,
            R.string.category8, R.string.question8,
            R.string.category9, R.string.question9
	};

	private static final int[] OPTIONS_LOOKUP_TABLE = new int[] {
	        R.array.options0,
            R.array.options1,
            R.array.options2,
            R.array.options3,
            R.array.options4,
            R.array.options5,
            R.array.options6,
            R.array.options7,
            R.array.options8,
            R.array.options9
    };

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
				R.layout.fragment_question_4options, container, false);

		tv_questionTitle = (TextView) rootView.findViewById(R.id.questionText);
		tv_questionTitle.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber + 1]));

		tv_category = (TextView) rootView.findViewById(R.id.category);
		tv_category.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber]));

		String[] options = getResources().getStringArray(OPTIONS_LOOKUP_TABLE[mPageNumber]);
		tv_option1 = (TextView) rootView.findViewById(R.id.option1);
        tv_option2 = (TextView) rootView.findViewById(R.id.option2);
        tv_option3 = (TextView) rootView.findViewById(R.id.option3);
        tv_option4 = (TextView) rootView.findViewById(R.id.option4);

        tv_option1.setText(options[0]);
        tv_option2.setText(options[0]);
        tv_option3.setText(options[0]);
        tv_option4.setText(options[0]);
		return rootView;
	}
}
