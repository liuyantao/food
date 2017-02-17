package com.example.dllo.food.homepagefragment;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.dllo.food.R;
import com.example.dllo.food.adapter.HomePageEvaluationAdapter;
import com.example.dllo.food.bean.HomePageEvaluationBean;
import com.example.dllo.food.fragment.BaseFragment;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;

import java.util.ArrayList;
import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageEvaluationFragment extends BaseFragment {
    private RecyclerView recyclerView;
    public static final String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=2&per=10";
    private List<HomePageEvaluationBean.FeedsBean> datas;
    private HomePageEvaluationAdapter homePageEvaluationAdapter;

    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public int setLayout() {
        return R.layout.homepage_evaluation_fragment;

    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.homepage_evaluation_fragment_rv);
        homePageEvaluationAdapter = new HomePageEvaluationAdapter(context);
        recyclerView.setAdapter(homePageEvaluationAdapter);
    }

    @Override
    public void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        NextTool.getInstance().startRequest(url, HomePageEvaluationBean.class, new CallBack<HomePageEvaluationBean>() {
            @Override
            public void onSuccess(HomePageEvaluationBean response) {
                datas = response.getFeeds();
                homePageEvaluationAdapter.setDatas(datas);
            }

            @Override
            public void onError(Throwable e) {

            }


        });

    }
}
