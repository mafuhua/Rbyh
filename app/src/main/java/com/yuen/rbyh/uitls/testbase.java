package com.yuen.rbyh.uitls;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuen.baselib.adapter.BaseHolder;
import com.yuen.baselib.adapter.DefaultAdapter;
import com.yuen.rbyh.R;

import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */
public class testbase extends AppCompatActivity {
    class base extends DefaultAdapter {
        public base(List datas) {
            super(datas);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.layout_zbrx_item, null);
            }
            return super.getView(position, convertView, parent);
        }

        @Override
        public BaseHolder getHolder() {
            return null;
        }



    }

}

