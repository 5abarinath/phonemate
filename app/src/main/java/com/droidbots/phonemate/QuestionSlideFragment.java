package com.droidbots.phonemate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sabari on 27/1/18.
 */

public class QuestionSlideFragment extends Fragment {
	private int mPageNumber;
	private TextView tv_questionTitle, tv_category;
	private RadioButton tv_option1, tv_option2, tv_option3, tv_option4;
	private SeekBar seekBar;
	private RadioGroup radioGroup;

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

	/*
	1. SmartPhone, 2. Os, 3. Price, 4. general usage, 5. Battery, 6. Storage, 7. Cam, 8. dimen
	9. Ram, 10. Weight
	 */
	private static final int[] FRAGMENT_LOOKUP_TABLE = new int[] {
			R.layout.fragment_question_2options,
			R.layout.fragment_question_3options,
			R.layout.fragment_question_slider,
			R.layout.fragment_question_3options,
			R.layout.fragment_question_3options,
			R.layout.fragment_question_3options,
			R.layout.fragment_question_3options,
			R.layout.fragment_question_3options,
			R.layout.fragment_question_3options,
			R.layout.fragment_question_2options
	};

	private static final String[] SHAREDPREF_KEY_LOOKUP_TABLE = new String[] {
			"smartphone",
			"os",
			"price",
			"busage",
			"battery",
			"storage",
			"camera",
			"screen",
			"ram",
			"weight"
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
		int fragment = FRAGMENT_LOOKUP_TABLE[mPageNumber];
		ViewGroup rootView = (ViewGroup) inflater.inflate(
				fragment, container, false);

		final SharedPreferences mSharedPref = getActivity().getSharedPreferences("userAnswers",
				Context.MODE_PRIVATE);


		boolean radioGroupPresent = true;

		if(fragment == R.layout.fragment_question_2options) {
			tv_questionTitle = (TextView) rootView.findViewById(R.id.questionText);
			tv_questionTitle.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber + 1]));

			tv_category = (TextView) rootView.findViewById(R.id.category);
			tv_category.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber]));

			String[] options = getResources().getStringArray(OPTIONS_LOOKUP_TABLE[mPageNumber]);
			tv_option1 = (RadioButton) rootView.findViewById(R.id.option1);
			tv_option2 = (RadioButton) rootView.findViewById(R.id.option2);

			tv_option1.setText(options[0]);
			tv_option2.setText(options[1]);
		}
		else if(fragment == R.layout.fragment_question_3options) {
			tv_questionTitle = (TextView) rootView.findViewById(R.id.questionText);
			tv_questionTitle.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber + 1]));

			tv_category = (TextView) rootView.findViewById(R.id.category);
			tv_category.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber]));

			String[] options = getResources().getStringArray(OPTIONS_LOOKUP_TABLE[mPageNumber]);
			tv_option1 = (RadioButton) rootView.findViewById(R.id.option1);
			tv_option2 = (RadioButton) rootView.findViewById(R.id.option2);
			tv_option3 = (RadioButton) rootView.findViewById(R.id.option3);

			tv_option1.setText(options[0]);
			tv_option2.setText(options[1]);
			tv_option3.setText(options[2]);
		}
		else if(fragment == R.layout.fragment_question_4options) {
			tv_questionTitle = (TextView) rootView.findViewById(R.id.questionText);
			tv_questionTitle.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber + 1]));

			tv_category = (TextView) rootView.findViewById(R.id.category);
			tv_category.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber]));

			String[] options = getResources().getStringArray(OPTIONS_LOOKUP_TABLE[mPageNumber]);
			tv_option1 = (RadioButton) rootView.findViewById(R.id.option1);
			tv_option2 = (RadioButton) rootView.findViewById(R.id.option2);
			tv_option3 = (RadioButton) rootView.findViewById(R.id.option3);
			tv_option4 = (RadioButton) rootView.findViewById(R.id.option4);

			tv_option1.setText(options[0]);
			tv_option2.setText(options[1]);
			tv_option3.setText(options[2]);
			tv_option4.setText(options[3]);
		}
		else if(fragment == R.layout.fragment_question_slider) {
			tv_questionTitle = (TextView) rootView.findViewById(R.id.questionText);
			tv_questionTitle.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber + 1]));

			tv_category = (TextView) rootView.findViewById(R.id.category);
			tv_category.setText(getString(QUESTION_LOOKUP_TABLE[2 * mPageNumber]));

			final TextView seekValue = (TextView) rootView.findViewById(R.id.seekValue);

			seekBar = (SeekBar) rootView.findViewById(R.id.seekBar);
			seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
					int val = 5000 + 450 * progress;
					seekValue.setText(String.valueOf(val));
				}

				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
//					Toast.makeText(getActivity(),"seekbar start", Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
//					Toast.makeText(getActivity(),"seekbar stop", Toast.LENGTH_SHORT).show();
					SharedPreferences.Editor editor = mSharedPref.edit();
					editor.putString(SHAREDPREF_KEY_LOOKUP_TABLE[mPageNumber], seekValue.getText().toString());
					editor.apply();
				}
			});
			radioGroupPresent = false;
		}

		if(radioGroupPresent) {
			radioGroup = (RadioGroup) rootView.findViewById(R.id.optionGroup);

			radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					SharedPreferences.Editor editor = mSharedPref.edit();
					//TODO Replace answer option with analysed answer
					String[] options = getResources().getStringArray(OPTIONS_LOOKUP_TABLE[mPageNumber]);
					int optionIndex = 0;
					if(checkedId == R.id.option1)
						optionIndex = 0;
					else if(checkedId == R.id.option2)
						optionIndex = 1;
					else if(checkedId == R.id.option3)
						optionIndex = 2;
					else if(checkedId == R.id.option4)
						optionIndex = 3;
					if(mPageNumber==1)
						editor.putString(SHAREDPREF_KEY_LOOKUP_TABLE[mPageNumber], String.valueOf(optionIndex+1));
					else
						editor.putString(SHAREDPREF_KEY_LOOKUP_TABLE[mPageNumber], String.valueOf(optionIndex));
					editor.apply();
				}
			});
		}
		return rootView;
	}
}
