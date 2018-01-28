package com.droidbots.phonemate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sabari on 27/1/18.
 */

public class QuestionSlidePagerAdapter extends FragmentStatePagerAdapter {
    private int NUM_PAGES;

    public QuestionSlidePagerAdapter(FragmentManager fm) {
        super(fm);
        NUM_PAGES = 10;
    }

    @Override
    public Fragment getItem(int position) {
        return QuestionSlideFragment.create(position);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
