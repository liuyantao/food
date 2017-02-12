package com.example.dllo.food.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        initView();
        initData();
        bindEvent();

    }

    //静态方法 布局
    protected abstract int bindLayout();
    //静态方法 绑定id
    protected abstract void initView();
    //写方法
    protected abstract void initData();

    protected abstract void bindEvent();

    protected <T extends View> T bindView(int resId) {
        return (T) findViewById(resId);
    }

}
