package com.example.dllo.food.activity;

import android.view.View;
import android.widget.Button;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseActivity;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class RegisterActivity extends BaseActivity{
    private  Button button;

    @Override
    protected int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        button = (Button) findViewById(R.id.activity_register_tv);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }
}
