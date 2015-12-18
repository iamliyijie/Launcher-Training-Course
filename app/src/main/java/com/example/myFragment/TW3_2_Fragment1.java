package com.example.myFragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.training.R;

public class TW3_2_Fragment1 extends Fragment
{
    static String Tag = "NewFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(Tag, "onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.newtestfragment1, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(Tag, "onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(Tag, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(Tag, "onDetach()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(Tag, "onPause()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(Tag, "onResume()");
        Log.i(Tag, "============");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(Tag, "onStart()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(Tag, "onStop()");
    }


    @Override
    public void onAttach(Activity activity) {
        Log.i(Tag, "onAttach()");
        super.onAttach(activity);
    }

}