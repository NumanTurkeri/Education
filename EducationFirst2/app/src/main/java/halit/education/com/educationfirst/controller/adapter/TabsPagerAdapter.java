package halit.education.com.educationfirst.controller.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import halit.education.com.educationfirst.controller.fragments.FirstFragment;
import halit.education.com.educationfirst.controller.fragments.SecondFragment;
import halit.education.com.educationfirst.controller.fragments.ThirthFragment;

/**
 * Created by numan_turkeri on 10.11.2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private int NUM_ITEMS = 3;
    private String[] titles= new String[]{"First Fragment", "Second Fragment","Third Fragment"};

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return  NUM_ITEMS ;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirthFragment();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return  titles[position];
    }

}