package com.monkey.firstline.unit3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.monkey.firstline.R;
import com.monkey.firstline.unit3.adapter.MessageAdapter;
import com.monkey.firstline.unit3.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends Activity {
    private ListView lvMessage;
    private EditText etInput;
    private Button btnSend;
    private ArrayAdapter<Message> adapter;

    private List<Message> msgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_message);
        lvMessage = (ListView) findViewById(R.id.lv_message);
        etInput = (EditText) findViewById(R.id.et_input);
        btnSend = (Button) findViewById(R.id.btn_send);

        initData();

        adapter = new MessageAdapter(this, R.layout.item_message, msgList);
        lvMessage.setAdapter(adapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = etInput.getText().toString();
                etInput.setText("");
                Message msg = new Message(content, Message.TYPE_SENT);
                msgList.add(msg);
                adapter.notifyDataSetChanged();
                // listview跳转到最后一行显示
                // 下标从0开始，但是此处不会报下标越界错误，设置 msgList.size()-1更易于理解
                lvMessage.setSelection(msgList.size());
            }
        });
    }

    private void initData() {
        msgList = new ArrayList<>();
        Message msg1 = new Message("Hello~~", Message.TYPE_SENT);
        Message msg2 = new Message("Ni hao!", Message.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
    }
}
