package com.example.training;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by YiJie_Li on 2015/12/23.
 */
public class TrainingWeek5_2 extends Activity {

    TextView Tv_name, Tv_tel, Tv_mail;
    EditText Edtxt_name, Edtxt_tel, Edtxt_mail;
    Button Btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainingweek5_2);

        Tv_name = (TextView) findViewById(R.id.tv_tw52_name);
        Tv_tel = (TextView) findViewById(R.id.tv_tw52_tel);
        Tv_mail = (TextView) findViewById(R.id.tv_tw52_mail);

        Edtxt_name = (EditText) findViewById(R.id.edTxt_tw52_name);
        Edtxt_tel = (EditText) findViewById(R.id.edTxt_tw52_tel);
        Edtxt_mail = (EditText) findViewById(R.id.edTxt_tw52_mail);

        Btn_click = (Button) findViewById(R.id.btn_tw52);

        PersonParcelable p = (PersonParcelable) getIntent().getParcelableExtra("PersonParcelable");
        Tv_tel.setText(p.getTel().toString());
        Tv_name.setText(p.getName().toString());
        Tv_mail.setText(p.getMail().toString());

        Btn_click.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
//                判斷Edtxt是否空白
                if ("".equals(Edtxt_name.getText().toString().trim()) || "".equals(Edtxt_tel.getText().toString().trim()) || "".equals(Edtxt_mail.getText().toString().trim())) {
                    myToast("請輸入Name、Tel、Mail");
                } else {
                    PersonParcelable p = new PersonParcelable();
                    p.setName(Edtxt_name.getText().toString());
                    p.setTel(Integer.parseInt(Edtxt_tel.getText().toString()));
                    p.setMail(Edtxt_mail.getText().toString());

                    Intent intent = getIntent();
                    Bundle bundle = new Bundle();

                    bundle.putParcelable("PersonParcelable", p);
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    finish();
                }
            }
        });
    }

    public void myToast(String txt) {
        Context context = getApplication();
        CharSequence toastText = txt;
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, toastText, duration).show();
    }
}