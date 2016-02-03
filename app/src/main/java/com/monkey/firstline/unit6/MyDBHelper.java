package com.monkey.firstline.unit6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MonkeyKiky on 2016/1/16.
 */
public class MyDBHelper extends SQLiteOpenHelper {
    private static final String CREATE_BOOK = "create table book (" +
            "id integer primary key autoincrement, " +
            "author text, " +
            "price real, " +
            "pages integer, " +
            "name text," +
            "category_id integer)";
    private static final String CREATE_CATEGORY = "create table category (" +
            "id integer primary key autoincrement," +
            "name text," +
            "code integer)";

    private Context mContext;

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                db.execSQL(CREATE_CATEGORY);
            case 2:
                db.execSQL("alter table book add column category_id integer");
            default:
        }
    }
}
