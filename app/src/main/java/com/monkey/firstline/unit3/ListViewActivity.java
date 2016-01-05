package com.monkey.firstline.unit3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.monkey.firstline.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView mListView;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_list_view);
        mListView = (ListView) findViewById(R.id.listView);
        initData();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(adapter);
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("item" + i);
        }
    }
}
