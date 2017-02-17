package com.example.dllo.food.homepagefragment;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.food.R;
import com.example.dllo.food.adapter.HomePageFoodAdapter;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.bean.HomePageFoodBean;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageFoodFragment extends BaseFragment{
      private RecyclerView recyclerView;
    private List<HomePageFoodBean.FeedsBean> datas;
    private HomePageFoodAdapter homePageFoodAdapter;
    private static final String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=4&per=10";

    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public int setLayout() {
        return R.layout.fragment_homepage_food;
    }

    @Override
    public void initView(View view) {
    recyclerView = (RecyclerView) view.findViewById(R.id.homepage_food_fragment_rl);
        homePageFoodAdapter = new HomePageFoodAdapter(context);
        recyclerView.setAdapter(homePageFoodAdapter);
    }

    @Override
    public void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        NextTool.getInstance().startRequest(url, HomePageFoodBean.class, new CallBack<HomePageFoodBean>() {
            @Override
            public void onSuccess(HomePageFoodBean response) {
                datas = response.getFeeds();
                homePageFoodAdapter.setDatas(datas);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
