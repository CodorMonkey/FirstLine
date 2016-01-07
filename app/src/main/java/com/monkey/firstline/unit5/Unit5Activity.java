package com.monkey.firstline.unit5;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import com.monkey.firstline.R;
import com.monkey.firstline.common.BaseActivity;
import com.monkey.firstline.unit5.receiver.LocalReceiver;
import com.monkey.firstline.unit5.receiver.NetworkChangeReceiver;

public class Unit5Activity extends BaseActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_unit5);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localReceiver = new LocalReceiver();
        IntentFilter localFilter = new IntentFilter("com.monkey.firstline.unit5.receiver.LocalReceiver");
        localBroadcastManager.registerReceiver(localReceiver, localFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.monkey.firstline.unit5.receiver.MyReceiver");
        sendOrderedBroadcast(intent, null);

        intent = new Intent("com.monkey.firstline.unit5.receiver.LocalReceiver");
        localBroadcastManager.sendBroadcast(intent);
    }

    public void showLogoutDemo(View view) {
        Intent intent = new Intent(this, LogoutDemoActivity.class);
        startActivity(intent);
    }

    public void forceLogout(View view) {
        Intent intent = new Intent("com.monkey.firstline.unit5.receiver.FORCE_OFFLINE");
        sendBroadcast(intent);
    }
}