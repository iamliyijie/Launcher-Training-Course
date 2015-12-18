package com.example.training;

/**
 * Created by YiJie_Li on 2015/12/18.
 */

import android.util.Log;
import android.view.View;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.myFragment.TW3_2_Fragment1;
import com.example.myFragment.TW3_2_Fragment2;
import com.example.myFragment.TW3_2_Fragment3;
import com.example.myFragment.TW3_2_Fragment4;

public class TrainingWeek3_2 extends Activity implements View.OnClickListener {
    private LinearLayout tabBut1,tabBut2,tabBut3,tabBut4;

    static String Tag = "NewTest";

    private TW3_2_Fragment1 newFragment1;
    private TW3_2_Fragment2 newFragment2;
    private TW3_2_Fragment3 newFragment3;
    private TW3_2_Fragment4 newFragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(Tag, "onCreate()");

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.newtest);

        tabBut1 = (LinearLayout) findViewById(R.id.tab_btn_1);
        tabBut2 = (LinearLayout) findViewById(R.id.tab_btn_2);
        tabBut3 = (LinearLayout) findViewById(R.id.tab_btn_3);
        tabBut4 = (LinearLayout) findViewById(R.id.tab_btn_4);
        tabBut1.setOnClickListener(this);
        tabBut2.setOnClickListener(this);
        tabBut3.setOnClickListener(this);
        tabBut4.setOnClickListener(this);

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        newFragment1 = new TW3_2_Fragment1();
        transaction.replace(R.id.id_content, newFragment1);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId()) {
            case R.id.tab_btn_1:
                if (newFragment1 == null) {
                    newFragment1 = new TW3_2_Fragment1();
                }
                transaction.replace(R.id.id_content, newFragment1);
                break;
            case R.id.tab_btn_2:
                if (newFragment2 == null) {
                    newFragment2 = new TW3_2_Fragment2();
                }
                transaction.replace(R.id.id_content, newFragment2);
                break;
            case R.id.tab_btn_3:
                if (newFragment3 == null) {
                    newFragment3 = new TW3_2_Fragment3();
                }
                transaction.replace(R.id.id_content, newFragment3);
                break;
            case R.id.tab_btn_4:
                if (newFragment4 == null) {
                    newFragment4 = new TW3_2_Fragment4();
                }
                transaction.replace(R.id.id_content, newFragment4);
                break;
        }
        // transaction.addToBackStack();
        transaction.commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "onDestory()");
        Log.i(Tag, "============");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag, "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag, "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag, "onStart()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag, "onStop()");
        Log.i(Tag, "============");
    }
}
