package com.monkey.firstline.unit2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.monkey.firstline.R;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_first);
        mBtnSend = (Button) findViewById(R.id.btnSend);
        mBtnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSend:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("name", "Monkey");
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                String name = data.getStringExtra("name");
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
