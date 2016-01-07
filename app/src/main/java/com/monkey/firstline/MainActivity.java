package com.monkey.firstline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.monkey.firstline.common.BaseActivity;
import com.monkey.firstline.unit2.FirstActivity;
import com.monkey.firstline.unit3.CustomerTitleActivity;
import com.monkey.firstline.unit4.Unit4Activity;
import com.monkey.firstline.unit5.Unit5Activity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
    }

    public void showUnit2(View view) {
        startActivity(new Intent(this, FirstActivity.class));
    }

    public void showUnit3(View view) {
        startActivity(new Intent(this, CustomerTitleActivity.class));
    }

    public void showUnit4(View view) {
        startActivity(new Intent(this, Unit4Activity.class));
    }

    public void showUnit5(View view) {
        startActivity(new Intent(this, Unit5Activity.class));
    }
}