package com.example.dllo.food.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseActivity;

public class LibrarySearchActivity extends BaseActivity {
   private Button mButton;


    @Override
    protected int bindLayout() {
        return R.layout.activity_library_search;
    }

    @Override
    protected void initView() {
        mButton = (Button) findViewById(R.id.activity_library_search_button);
    mButton.setOnClickListener(new View.OnClickListener() {
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
