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
 * Activity傳遞參數練習
 * 作法1. 使用Intent Bundle  (可傳遞基本型別)
 * 作法2.  實作Serializable (傳遞自訂物件)
 * 作法3.  實作Parcelable (傳遞自訂物件，效能較Serializable好)
 */
public class TrainingWeek5_1 extends Activity {

    TextView Tv_name,Tv_tel,Tv_mail;
    EditText Edtxt_name,Edtxt_tel,Edtxt_mail;
    Button Btn_click;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainingweek5_1);

        Tv_name = (TextView)findViewById(R.id.tv_tw51_name);
        Tv_tel = (TextView)findViewById(R.id.tv_tw51_tel);
        Tv_mail = (TextView)findViewById(R.id.tv_tw51_mail);

        Edtxt_name = (EditText)findViewById(R.id.edtTxt_tw51_name);
        Edtxt_tel = (EditText)findViewById(R.id.edtTxt_tw51_tel);
        Edtxt_mail = (EditText)findViewById(R.id.edtTxt_tw51_mail);
        Btn_click = (Button)findViewById(R.id.btn_tw51);

        Btn_click.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonParcelable p = new PersonParcelable();
                if ("".equals(Edtxt_name.getText().toString().trim()) || "".equals(Edtxt_tel.getText().toString().trim()) || "".equals(Edtxt_mail.getText().toString().trim())) {
                    myToast("請輸入Name、Tel、mail");
                } else {

                    p.setName(Edtxt_name.getText().toString());
                    p.setTel(Integer.parseInt(Edtxt_tel.getText().toString()));
                    p.setMail(Edtxt_mail.getText().toString());

                    Intent i = new Intent();
                    i.setClass(TrainingWeek5_1.this, TrainingWeek5_2.class);
                    i.putExtra("PersonParcelable", p);
                    startActivityForResult(i, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1  && resultCode == 1){
            PersonParcelable p = data.getExtras().getParcelable("PersonParcelable");
            Tv_tel.setText(p.getTel().toString());
            Tv_name.setText(p.getName().toString());
            Tv_mail.setText(p.getMail().toString());
        }
    }

    public void myToast(String txt) {
        Context context = getApplication();
        CharSequence toastText = txt;
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, toastText, duration).show();
    }
}