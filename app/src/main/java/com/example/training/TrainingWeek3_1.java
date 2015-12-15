package com.example.training;

/**
 * Created by YiJie_Li on 2015/12/14.
 */

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrainingWeek3_1 extends Activity {
    /**
     * Called when the activity is first created.
     */
    static String Tag = "T_Activity";
    ScrollView logContainer;
    TextView textViewLog;
    String line = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(Tag, "onCreate()");
        setContentView(R.layout.trainingweek3_1);
        logContainer = (ScrollView) findViewById(R.id.sv);
        textViewLog = (TextView) findViewById(R.id.tv);

        thread();

    }

    public void thread() {
        new AsyncTask<Void, String, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Process process = Runtime.getRuntime().exec("logcat");
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    while ((line = bufferedReader.readLine()) != null) {
                        if (line.contains("I/T_")) {
                            publishProgress(line);
                        }
                    }
                } catch (IOException e) {
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(String... values) {
                textViewLog.append(values[0] + "\n");
                logContainer.post(new Runnable() {
                    @Override
                    public void run() {
                        logContainer.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        }.execute();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "onDestory()");
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
    }

}
