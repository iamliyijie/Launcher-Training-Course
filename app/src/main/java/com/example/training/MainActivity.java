package com.example.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.PagerTitleStripDemo_Sample.TrainingWeek2_Sample;

public class MainActivity extends Activity {
    public Button testBtn1, testBtn2, testBtn3, testBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testBtn1 = (Button) findViewById(R.id.button1);
        testBtn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrainingWeek1.class);
                startActivity(intent);
            }
        });

        testBtn2 = (Button) findViewById(R.id.button2);
        testBtn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrainingWeek2.class);
                startActivity(intent);
            }
        });

        testBtn3 = (Button) findViewById(R.id.button3);
        testBtn3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrainingWeek2_Sample.class);
                startActivity(intent);
            }
        });

        testBtn4 = (Button) findViewById(R.id.button4);
        testBtn4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, test.class);
                startActivity(intent);
            }
        });
    }
}
