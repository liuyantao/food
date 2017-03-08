package com.example.dllo.food.homepagefragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.food.R;
import com.example.dllo.food.activity.homepageactivity.HomePageEvaluationNextActivity;
import com.example.dllo.food.adapter.HomePageFoodAdapter;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.bean.HomePageEvaluationBean;
import com.example.dllo.food.bean.HomePageFoodBean;
import com.example.dllo.food.bean.HomePageHomeBean;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;
import com.example.dllo.food.util.OnRecycleViewItemClick;
import com.example.dllo.food.util.Scorell;

import java.util.ArrayList;
import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageFoodFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
      private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<HomePageFoodBean.FeedsBean> datas;
    private HomePageFoodAdapter homePageFoodAdapter;
    private int pager = 1;
    private Receiver receiver;
    private static final String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=4&per=10";

    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public int setLayout() {
        return R.layout.fragment_homepage_food;
    }

    @Override
    public void initView(View view) {
    recyclerView = (RecyclerView) view.findViewById(R.id.homepage_food_fragment_rl);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.homepage_food_fragment_sr);
        homePageFoodAdapter = new HomePageFoodAdapter(context);

        recyclerView.setAdapter(homePageFoodAdapter);

    }

    @Override
    public void initData() {
        //规定布局
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED);
        homePageFoodAdapter.setOnRecycleViewItemClick(new OnRecycleViewItemClick() {
            @Override
            public void Onclick(int position) {
                Intent intent = new Intent(getActivity(), HomePageEvaluationNextActivity.class);
                String link = datas.get(position).getLink();
                intent.putExtra("NextActivity",link);


                startActivity(intent);
            }
        });
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
        Scorell scorell = new Scorell(recyclerView, getContext());

        scorell.load();
        IntentFilter intentFilter = new IntentFilter("LOADING");
        receiver = new Receiver();
        getContext().registerReceiver(receiver, intentFilter);
    }
    class Receiver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {

            pager++;
            final String url1 = "http://food.boohee.com/fb/v1/feeds/category_feed?page="+pager+"&category=3&per=10";

            NextTool.getInstance().startRequest(url1, HomePageFoodBean.class, new CallBack<HomePageFoodBean>() {

                @Override
                public void onSuccess(HomePageFoodBean respomse) {

                    datas.addAll(respomse.getFeeds());
                    homePageFoodAdapter.setDatas(datas);
                }

                @Override
                public void onError(Throwable throwable) {


                }
            });
        }
    }

    @Override
    public void onRefresh() {

    }
}
