package com.example.dllo.food.homepagefragment;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.dllo.food.R;
import com.example.dllo.food.adapter.HomePageHomeAdapter;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.bean.HomePageHomeBean;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageHomeFragment extends BaseFragment{
    private RecyclerView recyclerView;
    private HomePageHomeAdapter homePageHomeAdapter;
    public static final String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=1&per=10";
    private List<HomePageHomeBean.FeedsBean> datas;
  private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public int setLayout() {
        return R.layout.fragment_homepage_home;
    }

    @Override
    public void initView(View view) {
     recyclerView = (RecyclerView) view.findViewById(R.id.homepage_home_fragment_rv);
        homePageHomeAdapter =  new HomePageHomeAdapter(context);
        recyclerView.setAdapter(homePageHomeAdapter);
    }

    @Override
    public void initData() {
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        NextTool.getInstance().startRequest(url, HomePageHomeBean.class, new CallBack<HomePageHomeBean>() {
            @Override
            public void onSuccess(HomePageHomeBean response) {
                datas = response.getFeeds();
                homePageHomeAdapter.setDatas(datas);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
