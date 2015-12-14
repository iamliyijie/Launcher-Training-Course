package com.example.myFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.example.training.R;

public class TW2_2_Fragment3 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		TextView tvTitle=new TextView(super.getActivity());
		tvTitle.setText("Fragment 3");
		tvTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		tvTitle.setBackgroundColor(getResources().getColor(R.color.mycolor_brown));
		return tvTitle;
	}
}
