package com.bawei.yupeng201979.view.beas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.yupeng201979.R;

/*
 *
 * 姓名：于鹏
 * 创建时间：
 * 具体功能：
 */public abstract class BeasActivity extends AppCompatActivity {
     public abstract int initLayout();
     public abstract void initFind();
     public abstract void initData();
     public abstract void initListen();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initFind();
        initData();
        initListen();
    }
}
