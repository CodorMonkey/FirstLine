package com.monkey.firstline.unit3.entity;

/**
 * Created by MonkeyKiky on 2016/1/3.
 */
public class Message {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private String content;
    private int type;

    public Message(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
