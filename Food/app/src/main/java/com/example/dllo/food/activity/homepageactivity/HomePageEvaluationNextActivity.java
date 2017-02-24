package com.example.dllo.food.activity.homepageactivity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseActivity;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageEvaluationNextActivity extends BaseActivity   {
    private Button mButton;
    private WebView mWebView;
    @Override
    protected int bindLayout() {
        return R.layout.activity_homepage_evaluation_next;
    }

    @Override
    protected void initView() {
        mWebView = (WebView) findViewById(R.id.homepage_evaluation_next_wv);
        mButton = (Button) findViewById(R.id.activity_homepage_evaluation_next);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(intent.getStringExtra("NextActivity"));
        mWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    protected void bindEvent() {

    }


}
