package com.monkey.firstline.unit2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.monkey.firstline.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnReturn;
    private TextView mTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_second);
        mBtnReturn = (Button) findViewById(R.id.btnReturn);
        mTvText = (TextView) findViewById(R.id.tvText);
        mBtnReturn.setOnClickListener(this);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mTvText.setText(String.format("%s   %s", mTvText.getText(), name));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReturn:
                Intent intent = new Intent();
                intent.putExtra("name", "Monkey!!!!");
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
