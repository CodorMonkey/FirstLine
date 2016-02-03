package com.monkey.firstline.unit7;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.monkey.firstline.R;

import java.util.ArrayList;
import java.util.List;

public class Unit7Activity extends Activity {
    private ListView mLvContact;
    private List<String> mContactList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_unit7);
        mLvContact = (ListView) findViewById(R.id.lv_contact);
        mContactList = getContactList();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mContactList);
        mLvContact.setAdapter(adapter);
    }

    private List<String> getContactList() {
        List<String> resultList = null;
        Cursor cursor = null;
        try {
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                resultList = new ArrayList<>();
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    resultList.add(name + "\n" + number);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return resultList;
    }
}
