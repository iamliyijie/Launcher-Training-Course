package com.example.myFragment;

/**
 * Created by YiJie_Li on 2015/12/14.
 */

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.training.R;

public class Calculator1Fragment extends Fragment {

    static String Tag = "Fragment1";
    public void onCreate(Bundle savedInstanceState){
    Log.i(Tag, "onCreate()............");
    super.onCreate(savedInstanceState);
}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.i(Tag, "onCreateView()............");
        return inflater.inflate(R.layout.trainingweek3_1, container, false);

    }

    public void onActivityCreated (Bundle savedInstanceState){
        Log.i(Tag, "onActivityCreate()............");
        super.onActivityCreated(savedInstanceState);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(Tag, "onDestroyView()............");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "onDestroy()............");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(Tag, "onDetach()............");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(Tag, "onPause()............");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(Tag, "onResume()............");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(Tag, "onStart()............");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(Tag, "onStop()............");
    }


    @Override
    public void onAttach(Activity activity) {
        Log.i(Tag, "onAttach()............");
        super.onAttach(activity);
    }
}
