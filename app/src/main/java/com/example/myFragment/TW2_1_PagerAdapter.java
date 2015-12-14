package com.example.myFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TW2_1_PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public TW2_1_PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TW2_1_Fragment1 tab1 = new TW2_1_Fragment1();
                return tab1;
            case 1:
                TW2_1_Fragment2 tab2 = new TW2_1_Fragment2();
                return tab2;
            case 2:
                TW2_1_Fragment3 tab3 = new TW2_1_Fragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}