package com.droidbots.phonemate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sabari on 27/1/18.
 */

public class QuestionSlidePagerAdapter extends FragmentStatePagerAdapter {
    public QuestionSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new QuestionSlideFragment();
    }

    @Override
    public int getCount() {
        return 10;
    }
}
