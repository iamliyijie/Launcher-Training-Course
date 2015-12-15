package com.example.myFragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.training.R;

public class TW3_1_Fragment extends Fragment {
    static String Tag = "T_Fragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(Tag, "onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tw3_1_fragment, container, false);
        Log.i(Tag, "onCreateView()");
        return v;
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

//    public void mylog(){
//        try {
//            Process process = Runtime.getRuntime().exec("logcat -d");
//            BufferedReader bufferedReader = new BufferedReader(
//                    new InputStreamReader(process.getInputStream()));
//
//            StringBuilder log=new StringBuilder();
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                log.append(line);
//            }
//
//            TextView textViewLog = (TextView)getView().findViewById(R.id.first);
//
//            Pattern p = Pattern.compile("on[A-Z][a-zA-Z]{1,15}");
//            Matcher m = p.matcher(log);
//            String res="";
//            while (m.find()){
//                res += m.group()+"\r\n";
//            }
//            textViewLog.setText(res);
//            res ="";
//        } catch (IOException e) {
//        }
//    }
}