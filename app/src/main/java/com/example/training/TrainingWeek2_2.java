package com.example.training;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myFragment.TW2_2_Fragment1;
import com.example.myFragment.TW2_2_Fragment2;
import com.example.myFragment.TW2_2_Fragment3;
import com.example.myFragment.TW2_2_Fragment4;
import com.example.myFragment.TW2_2_Fragment5;

public class TrainingWeek2_2 extends AppCompatActivity implements
        OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private ListView navList;
    private FragmentManager fm;
    private List<Fragment> fragments;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> adapter;
    private ActionBar actionBar;
    private String[] tabs = new String[]{" Fragment1 ", " Fragment2 ", " Fragment3 ", " Fragment4 ", " Fragment5 "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tw_2_2_activity_main);

        drawerLayout = (DrawerLayout) super.findViewById(R.id.drawer_layout);
        navList = (ListView) super.findViewById(R.id.left_drawer);
        navList.setOnItemClickListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        fragments = new ArrayList<Fragment>();
        fm = super.getSupportFragmentManager();
        initListView();
        initActionBar();
        initDrawerLayout();
        initFragments();
    }

    private void initListView() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, tabs);
        navList.setAdapter(adapter);
    }

    private void initFragments() {
        TW2_2_Fragment1 fragment1 = new TW2_2_Fragment1();
        fragments.add(fragment1);
        TW2_2_Fragment2 fragment2 = new TW2_2_Fragment2();
        fragments.add(fragment2);
        TW2_2_Fragment3 fragment3 = new TW2_2_Fragment3();
        fragments.add(fragment3);
        TW2_2_Fragment4 fragment4 = new TW2_2_Fragment4();
        fragments.add(fragment4);
        TW2_2_Fragment5 fragment5 = new TW2_2_Fragment5();
        fragments.add(fragment5);
        setFragments(0);
    }

    private void setFragments(int position) {
        fm.beginTransaction().replace(R.id.content_frame,
                fragments.get(position), "t" + position).commit();
    }

    private void initActionBar() {
        actionBar = super.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //設定ActionBar背景顏色、title顏色(無法使用)
//        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.default_white));
//        int titleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
//        TextView titleView = (TextView)findViewById(titleId);
//        System.out.println("titleId:" + titleId);
//        titleView.setTextColor(getResources().getColor(R.color.default_white));

        actionBar.setIcon(new ColorDrawable(0));
        actionBar.setTitle(tabs[0]);
    }

    private void initDrawerLayout() {
        toggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_launcher, R.string.drawer_open,
                R.string.drawer_closed) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // TODO Auto-generated method stub
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // TODO Auto-generated method stub
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(toggle);
    }

    private void toggleNav() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            drawerLayout.openDrawer(Gravity.START);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                toggleNav();
                break;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        setFragments(position);
        toggleNav();
        actionBar.setTitle(tabs[position]);
    }
}
