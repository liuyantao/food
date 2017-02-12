package com.example.dllo.food.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;

import com.example.dllo.food.R;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class WelcomeActivity extends BaseActivity {

    private CountDownTimer countDownTimer;
    @Override
    protected int bindLayout() {
        return R.layout.activity_welcome;

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        countDownTimer = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                MyJump();
            }
        }.start();


    }
    public void MyJump(){
        Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
        startActivity(intent);
        countDownTimer.cancel();

    }

    @Override
    protected void bindEvent() {

    }
}
