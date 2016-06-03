package com.yuen.rbyh.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuen.rbyh.R;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button iv_btn_back;
    private TextView tv_title_dec;
    private LinearLayout layout_title_bar;
    private Button btn_grbm;
    private Button btn_jsdj;
    private Button btn_zbrx;
    private Button btn_zbsm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    public void initView() {
        iv_btn_back = (Button) findViewById(R.id.iv_btn_back);
        tv_title_dec = (TextView) findViewById(R.id.tv_title_dec);
        layout_title_bar = (LinearLayout) findViewById(R.id.layout_title_bar);
        btn_grbm = (Button) findViewById(R.id.btn_grbm);
        btn_jsdj = (Button) findViewById(R.id.btn_jsdj);
        btn_zbrx = (Button) findViewById(R.id.btn_zbrx);
        btn_zbsm = (Button) findViewById(R.id.btn_zbsm);

        tv_title_dec.setText("首页");
        layout_title_bar.setBackgroundColor(getResources().getColor(R.color.title));

        iv_btn_back.setOnClickListener(this);
        btn_grbm.setOnClickListener(this);
        btn_jsdj.setOnClickListener(this);
        btn_zbrx.setOnClickListener(this);
        btn_zbsm.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_grbm:
                startActivity(GRBMActivity.class);
                break;
            case R.id.btn_jsdj:
                startActivity(JSDJActivity.class);
                break;
            case R.id.btn_zbrx:
                startActivity(ZBRXActivity.class);
                break;
            case R.id.btn_zbsm:
                startActivity(ZBSMActivity.class);
                break;
        }
    }
}
