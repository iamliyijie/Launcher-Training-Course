package com.example.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    public Button testBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testBtn = (Button) findViewById(R.id.button1);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrainingWeek1.class);
                startActivity(intent);
            }
        });

        testBtn = (Button) findViewById(R.id.button2);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrainingWeek2_1.class);
                startActivity(intent);
            }
        });

        testBtn = (Button) findViewById(R.id.button3);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrainingWeek2_2.class);
                startActivity(intent);
            }
        });

        testBtn = (Button) findViewById(R.id.button4);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrainingWeek3_1.class);
                startActivity(intent);
            }
        });

        testBtn = (Button) findViewById(R.id.button5);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrainingWeek3_2.class);
                startActivity(intent);
            }
        });

        testBtn = (Button) findViewById(R.id.button6);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, TrainingWeek3_1.class);
//                startActivity(intent);
            }
        });

        testBtn = (Button) findViewById(R.id.button7);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, TrainingWeek3_1.class);
//                startActivity(intent);
            }
        });

        testBtn = (Button) findViewById(R.id.button10);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, com.example.Google_Smaple_Flexible_UI.MainActivity.class);
                startActivity(intent);
            }
        });

        testBtn = (Button) findViewById(R.id.button11);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, com.example.Google_Smaple_Flexible_UI.MainActivity.class);
                startActivity(intent);
            }
        });

        testBtn = (Button) findViewById(R.id.button12);
        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), "Btn Click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, TrainingWeek3_2.class);
                startActivity(intent);
            }
        });
    }
}
