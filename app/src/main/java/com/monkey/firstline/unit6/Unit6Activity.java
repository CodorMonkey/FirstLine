package com.monkey.firstline.unit6;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.monkey.firstline.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit6Activity extends Activity {
    private final String tag = getClass().getSimpleName();

    private EditText mEtFileData;
    private MyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_unit6);
        mEtFileData = (EditText) findViewById(R.id.et_file_data);
        dbHelper = new MyDBHelper(this, "BookStore.db", null, 2);
        String data = load();
        if (!TextUtils.isEmpty(data)) {
            mEtFileData.setText(data);
            mEtFileData.setSelection(data.length());
            Toast.makeText(this, "还原数据成功~", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        save();
    }

    private String load() {
        FileInputStream input;
        BufferedReader reader = null;
        StringBuilder buffer = new StringBuilder();
        try {
            input = this.openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(input));
            String temp;
            while ((temp = reader.readLine()) != null) {
                buffer.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

    private void save() {
        FileOutputStream output;
        BufferedWriter writer = null;
        try {
            output = this.openFileOutput("data", MODE_PRIVATE);
            writer = new BufferedWriter(new java.io.OutputStreamWriter(output));
            writer.write(String.valueOf(mEtFileData.getText()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void createDB(View view) {
        dbHelper.getWritableDatabase();
    }

    public void addBook(View view) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues book = new ContentValues();
        book.put("author", "Monkey");
        book.put("price", 66);
        book.put("pages", 666);
        book.put("name", "The life of Monkey");
        long id = database.insert("book", null, book);
        if (id != -1) {
            Toast.makeText(this, "Add book success!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Add book fail!", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateBook(View view) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues book = new ContentValues();
        book.put("price", 6);
        int update = database.update("book", book, "name=?", new String[]{"The life of Monkey"});
        Toast.makeText(this, "Update " + update + " rows", Toast.LENGTH_SHORT).show();
    }

    public void queryBook(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("book", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String author = cursor.getString(cursor.getColumnIndex("author"));
            int pages = cursor.getInt(cursor.getColumnIndex("pages"));
            double price = cursor.getDouble(cursor.getColumnIndex("price"));
            Log.d(tag, "name:" + name);
            Log.d(tag, "author:" + author);
            Log.d(tag, "pages:" + pages);
            Log.d(tag, "price:" + price);
        }
        cursor.close();
    }

    public void replaceBook(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();
        try {
            db.delete("book", null, null);
            //int i = 1 / 0;
            ContentValues values = new ContentValues();
            values.put("name", "Java");
            values.put("author", "Monkey");
            values.put("pages", 200);
            values.put("price", 666);
            db.insert("book", null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }
}