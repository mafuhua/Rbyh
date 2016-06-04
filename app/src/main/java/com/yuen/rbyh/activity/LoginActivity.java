package com.yuen.rbyh.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yuen.baselib.utils.VerifyUtil;
import com.yuen.rbyh.R;
import com.yuen.rbyh.uitls.ContactURL;
import com.yuen.rbyh.uitls.XUtils;

import org.xutils.common.Callback;

import java.util.HashMap;


public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private EditText et_login_tel;
    private EditText et_login_password;
    private CheckBox cb_login_remember_password;
    private TextView iv_btn_login;
    private TextView tv_login_rigester;
    private TextView view_center_line;
    private TextView tv_login_forget_password;

    private String password;


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }


    @Override
    public void initView() {
        et_login_tel = (EditText) findViewById(R.id.et_login_tel);
        et_login_password = (EditText) findViewById(R.id.et_login_password);
        cb_login_remember_password = (CheckBox) findViewById(R.id.cb_login_remember_password);
        iv_btn_login = (TextView) findViewById(R.id.iv_btn_login);
        tv_login_rigester = (TextView) findViewById(R.id.tv_login_rigester);
        view_center_line = (TextView) findViewById(R.id.view_center_line);
        tv_login_forget_password = (TextView) findViewById(R.id.tv_login_forget_password);
        iv_btn_login.setOnClickListener(this);
        tv_login_rigester.setOnClickListener(this);
        tv_login_forget_password.setOnClickListener(this);
    }


    @Override
    public void loadData() {

    }

    private void submit() {
        // validate
        String tel = et_login_tel.getText().toString().trim();
        if (TextUtils.isEmpty(tel)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!VerifyUtil.isMobileNO(tel)) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        password = et_login_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        login(tel,password);
        // TODO validate success, do something


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_btn_login:

                submit();
                //login();
                break;
            case R.id.tv_login_rigester:
                startActivity(RegisterActivity.class);
                break;
            case R.id.tv_login_forget_password:
                startActivity(ForgetPswActivity.class);
                break;
        }
    }

    private void login(String tel, String password) {
        HashMap<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("pwd",password);
        XUtils.xUtilsPost(ContactURL.LOGIN_URL, map,new Callback.CommonCallback<String>() {
            //  XUtils.xUtilsGet("https://hao.360.cn/?src=360c", new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.print("---------" + result);
                startActivity(MainActivity.class);
                Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
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
