package com.example.training;

/**
 * Created by YiJie_Li on 2015/12/22.
 * 參考至:http://blog.tonycube.com/2011/11/androidsqlite.html
 */

import static android.provider.BaseColumns._ID;
import static com.example.DB.DbConstants.EMAIL;
import static com.example.DB.DbConstants.NAME;
import static com.example.DB.DbConstants.TABLE_NAME;
import static com.example.DB.DbConstants.TEL;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.DB.DBHelper;

public class TrainingWeek4 extends Activity implements OnClickListener {

    private DBHelper DBhelper;
    private TextView TvResult;
    private EditText EdtxtName,EdtxtTel,EdtxtEmail,EdtxtId;
    private Button BtnAdd,BtnDel,BtnUpdate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainingweek4);

        initView();

        openDatabase();
        show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDatabase();
    }

    private void openDatabase() {
        DBhelper = new DBHelper(this);
    }

    private void closeDatabase() {
        DBhelper.close();
    }

    private void initView() {
        TvResult = (TextView) findViewById(R.id.tv_tw4_result);

        EdtxtName = (EditText) findViewById(R.id.edTxt_tw4_name);
        EdtxtTel = (EditText) findViewById(R.id.edTxt_tw4_tel);
        EdtxtEmail = (EditText) findViewById(R.id.edTxt_tw4_mail);
        EdtxtId = (EditText) findViewById(R.id.edTxt_tw4_id);

        BtnAdd = (Button) findViewById(R.id.btn_tw4_add);
        BtnDel = (Button) findViewById(R.id.btn_tw4_del);
        BtnUpdate = (Button) findViewById(R.id.btn_tw4_update);

        BtnAdd.setOnClickListener(this);
        BtnDel.setOnClickListener(this);
        BtnUpdate.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tw4_add:
                add();
                break;

            case R.id.btn_tw4_del:
                del();
                break;

            case R.id.btn_tw4_update:
                update();
                break;

            default:
                break;
        }
        show();
    }

    private void add() {
        SQLiteDatabase db = DBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, EdtxtName.getText().toString());
        values.put(TEL, EdtxtTel.getText().toString());
        values.put(EMAIL, EdtxtEmail.getText().toString());
        db.insert(TABLE_NAME, null, values);

        cleanEditText();
    }

    private Cursor getCursor() {
        SQLiteDatabase db = DBhelper.getReadableDatabase();
        String[] columns = {_ID, NAME, TEL, EMAIL};

        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
        startManagingCursor(cursor);

        return cursor;
    }

    private void show() {

        Cursor cursor = getCursor();

        StringBuilder resultData = new StringBuilder("RESULT: \n");

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String tel = cursor.getString(2);
            String email = cursor.getString(3);

            resultData.append(id).append(": ");
            resultData.append(name).append(": ");
            resultData.append(tel).append(": ");
            resultData.append(email).append(": ");
            resultData.append("\n");
        }
        TvResult.setText(resultData);
    }

    private void del() {
        if("".equals(EdtxtId.getText().toString().trim())){
            myToast("請輸入ID");
        }else{
            String id = EdtxtId.getText().toString();
            SQLiteDatabase db = DBhelper.getWritableDatabase();
            db.delete(TABLE_NAME, _ID + "=" + id, null);
            cleanEditText();
        }
    }

    private void update() {

        if("".equals(EdtxtId.getText().toString().trim())){
            myToast("請輸入ID");
        }else{
            String id = EdtxtId.getText().toString();

            ContentValues values = new ContentValues();
            values.put(NAME, EdtxtName.getText().toString());
            values.put(TEL, EdtxtTel.getText().toString());
            values.put(EMAIL, EdtxtEmail.getText().toString());

            SQLiteDatabase db = DBhelper.getWritableDatabase();
            db.update(TABLE_NAME, values, _ID + "=" + id, null);

            cleanEditText();
        }
    }

    private void cleanEditText() {
        EdtxtName.setText("");
        EdtxtTel.setText("");
        EdtxtEmail.setText("");
        EdtxtId.setText("");
    }

    public void myToast(String txt) {
        Context context = getApplication();
        CharSequence toastText = txt;
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, toastText, duration).show();
    }
}