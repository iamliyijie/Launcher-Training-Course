package com.example.PagerTitleStripDemo_Sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.example.training.R;

public class Fragment5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        TextView tvTitle = new TextView(super.getActivity());
        tvTitle.setText("Fragment 5");
        tvTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        tvTitle.setBackgroundColor(getResources().getColor(R.color.mycolor_teal));
        return tvTitle;
    }
}
