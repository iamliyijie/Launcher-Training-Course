package com.example.myFragment;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TW2_2_PagerAdapter extends FragmentPagerAdapter {


    private List<String> tabs;
    private List<Fragment> fragmentList;

    public TW2_2_PagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> tabs) {
        super(fm);
        this.tabs = tabs;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int idx) {
        // TODO Auto-generated method stub
        return fragmentList.get(idx);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // TODO Auto-generated method stub
        return tabs.get(position);
    }

}
