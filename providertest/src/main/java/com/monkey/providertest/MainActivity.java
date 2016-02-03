package com.monkey.providertest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private final String tag = getClass().getSimpleName();

    private Button mBtnAddBook;
    private Button mBtnUpdateBook;
    private Button mBtnQueryBook;
    private Button mBtnDeleteBook;

    private String newBookId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mBtnAddBook = (Button) findViewById(R.id.btn_add_book);
        mBtnAddBook.setOnClickListener(this);
        mBtnUpdateBook = (Button) findViewById(R.id.btn_update_book);
        mBtnUpdateBook.setOnClickListener(this);
        mBtnQueryBook = (Button) findViewById(R.id.btn_query_book);
        mBtnQueryBook.setOnClickListener(this);
        mBtnDeleteBook = (Button) findViewById(R.id.btn_delete_book);
        mBtnDeleteBook.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_book:
                newBookId = addBook();
                break;
            case R.id.btn_query_book:
                queryBook();
                break;
            case R.id.btn_update_book:
                updateBook();
                break;
            case R.id.btn_delete_book:
                deleteBook();
                break;
        }
    }

    private void deleteBook() {
        Uri uri = Uri.parse("content://com.monkey.firstline.unit7.provider/book/" + newBookId);
        int deletedRows = getContentResolver().delete(uri, null, null);
        Toast.makeText(this, String.format("%d rows deleted", deletedRows), Toast.LENGTH_SHORT).show();
    }

    private void updateBook() {
        Uri uri = Uri.parse("content://com.monkey.firstline.unit7.provider/book/" + newBookId);
        ContentValues values = new ContentValues();
        values.put("name", "Monkey");
        int updatedRows = getContentResolver().update(uri, values, null, null);
        Toast.makeText(this, String.format("%d rows updated", updatedRows), Toast.LENGTH_SHORT).show();
    }

    private void queryBook() {
        Uri uri = Uri.parse("content://com.monkey.firstline.unit7.provider/book");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.d(tag, String.format("name:%s|author:%s|pages:%d|price:%f",
                        name, author, pages, price));
            }
            cursor.close();
        }
    }

    private String addBook() {
        String newId = null;
        Uri uri = Uri.parse("content://com.monkey.firstline.unit7.provider/book");
        ContentValues values = new ContentValues();
        values.put("name", "21天从入门到精通");
        values.put("author", "monkey");
        values.put("pages", 21);
        values.put("price", 8);
        Uri newUri = getContentResolver().insert(uri, values);
        if (newUri != null) {
            newId = newUri.getPathSegments().get(1);
        }
        return newId;
    }
}