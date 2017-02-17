package com.example.dllo.food.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.view.View;
import android.widget.RadioButton;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseActivity;
import com.example.dllo.food.fragment.HomePageFragment;
import com.example.dllo.food.fragment.LibraryFragment;
import com.example.dllo.food.fragment.MyFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton homepageBtn, libraryBtn, myBtn;
    private Fragment homepageFragment, libraryFragment, myFragment;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //绑定id  设置监听
        homepageBtn = (RadioButton) findViewById(R.id.tab_homepage);
        libraryBtn = (RadioButton) findViewById(R.id.tab_library);
        myBtn = (RadioButton) findViewById(R.id.tab_my);
        homepageBtn.setOnClickListener(this);
        libraryBtn.setOnClickListener(this);
        myBtn.setOnClickListener(this);
        //初始化fragment
        homepageFragment = new HomePageFragment();
        libraryFragment = new LibraryFragment();
        myFragment = new MyFragment();

        //设置进入界面的时候就是首页 食物百科的页面
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.tab_rg, libraryFragment);
        transaction.commit();
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onClick(View view) {
        //加载碎片
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //绑定id  实现方法replace移除
        switch (view.getId()) {
            case R.id.tab_library:
                transaction.replace(R.id.tab_rg, libraryFragment);
                break;
            case R.id.tab_homepage:
                transaction.replace(R.id.tab_rg, homepageFragment);
                break;

            case R.id.tab_my:
                transaction.replace(R.id.tab_rg, myFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    protected <T extends View> T bindView(int resId) {
        return super.bindView(R.id.tab_library);
    }
}
