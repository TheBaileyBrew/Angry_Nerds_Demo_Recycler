package com.thebaileybrew.angry_nerds_demo_recycler;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentHelper extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentHelper(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0: //Create Fragment Views based on display
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                return null;
        }
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return "ALPHABETICAL";
            case 1:
                return "SHUFFLE";
            case 2:
                return "SEARCH & RETURN";
            default:
                return null;
        }
    }
}
