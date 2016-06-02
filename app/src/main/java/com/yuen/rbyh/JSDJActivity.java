package com.yuen.rbyh;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.yuen.baselib.utils.VerifyUtil;

import xlkd.util.Util;

public class JSDJActivity extends Util implements View.OnClickListener {

    private Button iv_btn_back;
    private TextView tv_title_dec;
    private LinearLayout layout_title_bar;
    private EditText et_name;
    private RadioButton rbtn_nan;
    private RadioButton rbtn_nv;
    private EditText et_tel;
    private EditText et_idcard;
    private Spinner provinceSpinner;
    private Spinner citySpinner;
    private Spinner districtSpinner;
    private String tv_result;
    private Button btn_tijiao;
    private Spinner spinner0;
    private Context context;
    private String[] mCountries = new String[]{"福州市", "鼓楼区", "台江区", "仓山区", "晋安区", "马尾区",
            "福清", "长乐", "连江", "闽侯", "闽清", "罗源", "永泰"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsdj);
        initView();
        loadData();
    }

    @Override
    public void initView() {
        context = this;
        iv_btn_back = (Button) findViewById(R.id.iv_btn_back);
        iv_btn_back.setOnClickListener(this);
        tv_title_dec = (TextView) findViewById(R.id.tv_title_dec);
        tv_title_dec.setOnClickListener(this);
        layout_title_bar = (LinearLayout) findViewById(R.id.layout_title_bar);
        layout_title_bar.setOnClickListener(this);
        et_name = (EditText) findViewById(R.id.et_name);
        et_name.setOnClickListener(this);
        rbtn_nan = (RadioButton) findViewById(R.id.rbtn_nan);
        rbtn_nan.setOnClickListener(this);
        rbtn_nv = (RadioButton) findViewById(R.id.rbtn_nv);
        rbtn_nv.setOnClickListener(this);
        et_tel = (EditText) findViewById(R.id.et_tel);
        et_tel.setOnClickListener(this);
        et_idcard = (EditText) findViewById(R.id.et_idcard);
        et_idcard.setOnClickListener(this);
       /* provinceSpinner = (Spinner) findViewById(R.id.province);
        citySpinner = (Spinner) findViewById(R.id.city);
        districtSpinner = (Spinner) findViewById(R.id.district);*/
        btn_tijiao = (Button) findViewById(R.id.btn_tijiao);
        btn_tijiao.setOnClickListener(this);
        tv_title_dec.setText("家属登记");
        iv_btn_back.setVisibility(View.VISIBLE);
        layout_title_bar.setBackgroundColor(getResources().getColor(R.color.title));
        spinner0 = (Spinner) findViewById(R.id.spinner0);
        spinner0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                Log.d("mafuhua", mCountries[pos] + "你点击的是:" + pos);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setSpinnerContent(final Spinner spinners, final String[] mCountries) {
        if (mCountries == null) {
            return;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, mCountries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners.setAdapter(adapter);

    }

    @Override
    public void loadData() {
      /*  initProvinceDatas();
        ArrayAdapter<String> provinceAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mProvinceDatas);
        provinceSpinner.setAdapter(provinceAdapter);
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                mCurrentProviceName = mProvinceDatas[position];
                String[] cities = mCitisDatasMap.get(mCurrentProviceName);
                if (cities == null) {
                    cities = new String[]{""};
                }
                ArrayAdapter<String> cityAdapter = new ArrayAdapter<String>(JSDJActivity.this, android.R.layout.simple_list_item_1, cities);
                citySpinner.setAdapter(cityAdapter);
                mCurrentCityName = mCitisDatasMap.get(mCurrentProviceName)[0];
                String[] areas = mDistrictDatasMap.get(mCurrentCityName);
                mCurrentDistrictName = areas[0];
                if (areas == null) {
                    areas = new String[]{""};
                }
                ArrayAdapter<String> districtAdapter = new ArrayAdapter<String>(JSDJActivity.this, android.R.layout.simple_list_item_1, areas);
                districtSpinner.setAdapter(districtAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                mCurrentCityName = mCitisDatasMap.get(mCurrentProviceName)[position];
                String[] areas = mDistrictDatasMap.get(mCurrentCityName);
                mCurrentDistrictName = areas[0];
                if (areas == null) {
                    areas = new String[]{""};
                }
                ArrayAdapter<String> districtAdapter = new ArrayAdapter<String>(JSDJActivity.this, android.R.layout.simple_list_item_1, areas);
                districtSpinner.setAdapter(districtAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner sp = (Spinner) parent;
                mCurrentDistrictName = (String) sp.getItemAtPosition(position);
                tv_result = (mCurrentProviceName + "," + mCurrentCityName + "," + mCurrentDistrictName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_btn_back:
                finish();
                break;
            case R.id.btn_tijiao:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String name = et_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String tel = et_tel.getText().toString().trim();
        if (TextUtils.isEmpty(tel)) {
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String idcard = et_idcard.getText().toString().trim();
        if (TextUtils.isEmpty(idcard)) {
            Toast.makeText(this, "idcard不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!VerifyUtil.isIDCard(idcard)) {
            Toast.makeText(this, "请输入正确的身份证号", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("mafuhua", "-----tel + name + idcard ----" + tel + name + idcard);
        // TODO validate success, do something


    }
}
