package com.example.PagerTitleStripDemo_Sample;

import java.util.ArrayList;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.training.NewsFragmentPagerAdapter;
import com.example.training.R;

public class Fragment1 extends Fragment {

    private ViewPager mViewPager;
    private List<String> tabs;
    private List<Fragment> fragmentList;
    private NewsFragmentPagerAdapter adapter;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.sample_news_fragment, null);
            mViewPager = (ViewPager) view.findViewById(R.id.pager);
            initViewPager();
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) parent.removeView(view);
        return view;
    }

    private void initViewPager() {
        setTabs();
        setFragments();
        adapter = new NewsFragmentPagerAdapter(super.getActivity().getSupportFragmentManager(),
                fragmentList, tabs);
        mViewPager.setAdapter(adapter);
    }

    private void setFragments() {
        fragmentList = new ArrayList<Fragment>();
        for (int i = 0; i < tabs.size(); i++) {
            NewsChannelFragment1 fragment = new NewsChannelFragment1();
            Bundle bundle = new Bundle();
            bundle.putString("title", tabs.get(i));
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }
    }

    private void setTabs() {
        tabs = new ArrayList<String>();
        tabs.add("Tab 1");
        tabs.add("Tab 2");
        tabs.add("Tab 3");
        tabs.add("Tab 4");
    }
}
