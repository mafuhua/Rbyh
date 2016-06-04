package com.yuen.rbyh.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yuen.baselib.utils.VerifyUtil;
import com.yuen.rbyh.R;
import com.yuen.rbyh.uitls.ContactURL;
import com.yuen.rbyh.uitls.XUtils;

import org.xutils.common.Callback;

import java.util.HashMap;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private Button iv_btn_back;
    private TextView tv_title_dec;
    private LinearLayout layout_title_bar;
    private EditText et_tel;
    private EditText et_yzm;
    private Button btn_get_yzm;
    private EditText et_mima;
    private EditText et_mima2;
    private Button btn_queding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_psw);
        initView();

    }


    public void initView() {
        iv_btn_back = (Button) findViewById(R.id.iv_btn_back);
        tv_title_dec = (TextView) findViewById(R.id.tv_title_dec);
        layout_title_bar = (LinearLayout) findViewById(R.id.layout_title_bar);
        et_tel = (EditText) findViewById(R.id.et_tel);
        et_yzm = (EditText) findViewById(R.id.et_yzm);
        btn_get_yzm = (Button) findViewById(R.id.btn_get_yzm);
        et_mima = (EditText) findViewById(R.id.et_mima);
        et_mima2 = (EditText) findViewById(R.id.et_mima2);
        btn_queding = (Button) findViewById(R.id.btn_queding);

        iv_btn_back.setVisibility(View.VISIBLE);
        tv_title_dec.setText("注册");
        iv_btn_back.setOnClickListener(this);
        btn_get_yzm.setOnClickListener(this);
        btn_queding.setOnClickListener(this);
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
            case R.id.btn_get_yzm:

                break;
            case R.id.btn_queding:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String tel = et_tel.getText().toString().trim();
        if (TextUtils.isEmpty(tel)) {
            Toast.makeText(this, "请输入您的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!VerifyUtil.isMobileNO(tel)) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        String yzm = et_yzm.getText().toString().trim();
        if (TextUtils.isEmpty(yzm)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String mima = et_mima.getText().toString().trim();
        if (TextUtils.isEmpty(mima)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String mima2 = et_mima2.getText().toString().trim();
        if (TextUtils.isEmpty(mima2)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!mima.equals(mima2)){
            Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        register(tel,mima);


    }
    private void register(String tel, String password) {
        HashMap<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("pwd",password);
        XUtils.xUtilsPost(ContactURL.LOGIN_URL, map,new Callback.CommonCallback<String>() {
            //  XUtils.xUtilsGet("https://hao.360.cn/?src=360c", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("mafuhua", "---------" + result);
                startActivity(MainActivity.class);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
            }
        });
    }
}
