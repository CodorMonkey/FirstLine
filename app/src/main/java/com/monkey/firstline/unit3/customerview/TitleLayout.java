package com.monkey.firstline.unit3.customerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.monkey.firstline.R;

/**
 * Created by MonkeyKiky on 2016/1/2.
 */
public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.title, this);
        Button btnBack = (Button) findViewById(R.id.title_back);
        Button btnEdit = (Button) findViewById(R.id.title_edit);
        TextView tvTitle = (TextView) findViewById(R.id.title_text);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleLayout);
        String strBack = typedArray.getString(R.styleable.TitleLayout_Back_Text);
        String strEdit = typedArray.getString(R.styleable.TitleLayout_Edit_Text);
        String strTitle = typedArray.getString(R.styleable.TitleLayout_Title_Text);
        btnBack.setText(strBack);
        btnEdit.setText(strEdit);
        tvTitle.setText(strTitle);
    }
}
