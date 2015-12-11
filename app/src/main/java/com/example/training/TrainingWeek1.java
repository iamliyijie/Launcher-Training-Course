package com.example.training;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class TrainingWeek1 extends Activity{
	public static int temp = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		temp ++;
		myToast("onCreate");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trainingweek1);
	}
	@Override
	public void onStart(){
		temp ++;
	    super.onStart();
	    myToast("onStart");
	}

	@Override
	public void onResume(){
		temp ++;
	    super.onResume();
	    myToast("onResume");
	}
	
	@Override
	public void onPause(){
		temp ++;
	    super.onPause();
	    myToast("onPause");
	}
	
	@Override
	public void onStop(){
		temp ++;
	    super.onStop();
	    myToast("onStop");
	}
	
	@Override
	public void onDestroy(){
		temp ++;
	    super.onDestroy();
	    myToast("onDestroy");
	}
	
	@Override
	public void onRestart(){
		temp ++;
	    super.onRestart();
	    myToast("onRestart");
	}

	public void myToast(String txt){
		Context context = getApplication();
        CharSequence toastText = txt+":"+temp;
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, toastText, duration).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
