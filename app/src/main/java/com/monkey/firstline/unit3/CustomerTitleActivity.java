package com.monkey.firstline.unit3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.monkey.firstline.R;

public class CustomerTitleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_customer_title);
    }

    public void showListView(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void showMessageActivity(View view) {
        startActivity(new Intent(this, MessageActivity.class));
    }
}