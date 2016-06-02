package com.yuen.rbyh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ZBRXActivity extends BaseActivity implements View.OnClickListener {

    private Button iv_btn_back;
    private TextView tv_title_dec;
    private LinearLayout layout_title_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zbrx);
        initView();
    }

    @Override
    public void initView() {

        iv_btn_back = (Button) findViewById(R.id.iv_btn_back);
        iv_btn_back.setOnClickListener(this);
        tv_title_dec = (TextView) findViewById(R.id.tv_title_dec);
        tv_title_dec.setOnClickListener(this);
        layout_title_bar = (LinearLayout) findViewById(R.id.layout_title_bar);
        layout_title_bar.setOnClickListener(this);
        tv_title_dec.setText("征兵热线");
        iv_btn_back.setVisibility(View.VISIBLE);
        layout_title_bar.setBackgroundColor(getResources().getColor(R.color.title));
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_btn_back:
                finish();
                break;
        }
    }
}
