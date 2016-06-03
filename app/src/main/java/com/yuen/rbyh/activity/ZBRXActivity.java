package com.yuen.rbyh.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yuen.baselib.adapter.BaseHolder;
import com.yuen.baselib.adapter.DefaultAdapter;
import com.yuen.rbyh.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZBRXActivity extends BaseActivity implements View.OnClickListener {
    public String[] mCountries = new String[]{"福州市  何金刚", "鼓楼区  梁少明", "台江区  杨毅", "仓山区  彭建峰", "晋安区  叶小辉", "马尾区  陈志辉",
            "福清  方增松", "长乐  潘加兵", "连江  廖小军", "闽侯  林晓臻", "闽清  曾少华", "罗源  崔国荣", "永泰  江庆锋"};
    public String[] gongzhonghao = new String[]{"GDRBYH", "GLZBXZ24954265", "福州台江区征兵办", "FZCSZBB", "晋安区国防教育", "马尾国防在线",
            "FQZB110", "长乐市征兵办", "lianjiang_zbb", "闽侯县国防教育专栏", "MQZB2015", "LY26831340", "YTXZBBGS"};
    public String[] shoujihao = new String[]{"18960761978", "18960761586", "13338410668", "18960760302", "18960761578", "15880186782",
            "18065117006", "18900282296", "18900276123", "13609543201", "18960989811", "18859156733", "15005950091"};
    private List<String> mCountriesString = new ArrayList(Arrays.asList(mCountries));
    private List<String> gongzhonghaoString = new ArrayList(Arrays.asList(gongzhonghao));
    private List<String> shoujihaoString = new ArrayList(Arrays.asList(shoujihao));
    private Button iv_btn_back;
    private TextView tv_title_dec;
    private LinearLayout layout_title_bar;
    private ListView listView2;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zbrxian);
        initView();

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
        tv_title_dec.setText("征兵热线");
        iv_btn_back.setVisibility(View.VISIBLE);
        layout_title_bar.setBackgroundColor(getResources().getColor(R.color.title));
        listView2 = (ListView) findViewById(R.id.listView2);
        listView2.setAdapter(new MyAdapter(mCountriesString));
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

    class MyAdapter extends DefaultAdapter {
        public MyAdapter(List datas) {
            super(datas);
        }

        @Override
        public BaseHolder getHolder() {
            return new ViewHolder();
        }
    }

    public class ViewHolder extends BaseHolder<String> {
        TextView tvdanwei;
        TextView tvshouji;
        TextView tvgongzhonghao;


        @Override
        public View initView() {
            View view = View.inflate(context, R.layout.layout_zbrx_item, null);
            tvdanwei = (TextView) view.findViewById(R.id.tv_danwei);
            tvshouji = (TextView) view.findViewById(R.id.tv_shouji);
            tvgongzhonghao = (TextView) view.findViewById(R.id.tv_gongzhonghao);
            return view;
        }

        @Override
        public void refreshView(String data, int position) {
            tvdanwei.setText(data);
            tvshouji.setText("手机号:" + shoujihaoString.get(position));
            tvgongzhonghao.setText("微信公众号:" + gongzhonghaoString.get(position));
        }
    }
}
