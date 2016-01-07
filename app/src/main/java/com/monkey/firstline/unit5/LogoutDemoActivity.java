package com.monkey.firstline.unit5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.monkey.firstline.R;
import com.monkey.firstline.common.BaseActivity;

public class LogoutDemoActivity extends BaseActivity {
    private EditText mEtLoginName;
    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_logout_demo);
        mEtLoginName = (EditText) findViewById(R.id.et_login_name);
        mEtPassword = (EditText) findViewById(R.id.et_password);
    }

    public void login(View view) {
        String name = mEtLoginName.getText().toString();
        String pwd = mEtPassword.getText().toString();
        if ("admin".equals(name) && "123".equals(pwd)) {
            startActivity(new Intent(this, Unit5Activity.class));
        } else {
            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }
}