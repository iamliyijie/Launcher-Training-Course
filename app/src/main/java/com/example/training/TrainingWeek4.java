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

    private DBHelper dbhelper;
    private TextView result;
    private EditText editName,editTel,editEmail,editId;
    private Button btnAdd,btnDel,btnUpdate;

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
        dbhelper = new DBHelper(this);
    }

    private void closeDatabase() {
        dbhelper.close();
    }

    private void initView() {
        result = (TextView) findViewById(R.id.txtResult);

        editName = (EditText) findViewById(R.id.editName);
        editTel = (EditText) findViewById(R.id.editTel);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editId = (EditText) findViewById(R.id.editId);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        btnAdd.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                add();
                break;

            case R.id.btnDel:
                del();
                break;

            case R.id.btnUpdate:
                update();
                break;

            default:
                break;
        }

        show();
    }

    private void add() {
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, editName.getText().toString());
        values.put(TEL, editTel.getText().toString());
        values.put(EMAIL, editEmail.getText().toString());
        db.insert(TABLE_NAME, null, values);

        cleanEditText();
    }

    private Cursor getCursor() {
        SQLiteDatabase db = dbhelper.getReadableDatabase();
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
        result.setText(resultData);
    }

    private void del() {
        if("".equals(editId.getText().toString().trim())){
            myToast("請輸入ID");
        }else{
            String id = editId.getText().toString();
            SQLiteDatabase db = dbhelper.getWritableDatabase();
            db.delete(TABLE_NAME, _ID + "=" + id, null);
            cleanEditText();
        }
    }

    private void update() {

        if("".equals(editId.getText().toString().trim())){
            myToast("請輸入ID");
        }else{
            String id = editId.getText().toString();

            ContentValues values = new ContentValues();
            values.put(NAME, editName.getText().toString());
            values.put(TEL, editTel.getText().toString());
            values.put(EMAIL, editEmail.getText().toString());

            SQLiteDatabase db = dbhelper.getWritableDatabase();
            db.update(TABLE_NAME, values, _ID + "=" + id, null);

            cleanEditText();
        }
    }

    private void cleanEditText() {
        editName.setText("");
        editTel.setText("");
        editEmail.setText("");
        editId.setText("");
    }

    public void myToast(String txt) {
        Context context = getApplication();
        CharSequence toastText = txt;
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, toastText, duration).show();
    }
}