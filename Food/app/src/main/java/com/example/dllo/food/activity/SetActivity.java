package com.example.dllo.food.activity;

import android.view.View;
import android.widget.Button;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseActivity;
//设置界面
public class SetActivity extends BaseActivity {

    private Button button;

    @Override
    protected int bindLayout() {
        return R.layout.activity_my_set;
    }

    @Override
    protected void initView() {
    button = (Button) findViewById(R.id.activity_my_set_tv);
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
