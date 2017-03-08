package com.example.dllo.food.homepagefragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.dllo.food.R;
import com.example.dllo.food.activity.homepageactivity.HomePageEvaluationNextActivity;
import com.example.dllo.food.adapter.HomePageEvaluationAdapter;
import com.example.dllo.food.bean.HomePageEvaluationBean;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;
import com.example.dllo.food.util.OnRecycleViewItemClick;
import com.example.dllo.food.util.Scorell;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageEvaluationFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private int pager = 1;
    private Receiver receiver;
    private SwipeRefreshLayout swipeRefreshLayout;
    public static final String url = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=2&per=10";
    private List<HomePageEvaluationBean.FeedsBean> datas;
    private HomePageEvaluationAdapter homePageEvaluationAdapter;

    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public int setLayout() {
        return R.layout.fragment_homepage_evaluation;

    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.homepage_evaluation_fragment_rv);
        homePageEvaluationAdapter = new HomePageEvaluationAdapter(context);
        recyclerView.setAdapter(homePageEvaluationAdapter);
    }

    @Override
    public void initData() {

        datas=new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        homePageEvaluationAdapter.setOnRecycleViewItemClick(new OnRecycleViewItemClick() {
            @Override
            public void Onclick(int position) {
//                Toast.makeText(context, "点击事件 --- " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), HomePageEvaluationNextActivity.class);
                String link = datas.get(position).getLink();
                intent.putExtra("NextActivity", link);
                startActivity(intent);
            }
        });

        NextTool.getInstance().startRequest(url, HomePageEvaluationBean.class, new CallBack<HomePageEvaluationBean>() {
            @Override
            public void onSuccess(HomePageEvaluationBean response) {
                datas = response.getFeeds();
                homePageEvaluationAdapter.setDatas(response.getFeeds());
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

                NextTool.getInstance().startRequest(url1, HomePageEvaluationBean.class, new CallBack<HomePageEvaluationBean>() {

                    @Override
                    public void onSuccess(HomePageEvaluationBean respomse) {

                        datas.addAll(respomse.getFeeds());
                        homePageEvaluationAdapter.setDatas(datas);
                    }

                    @Override
                    public void onError(Throwable throwable) {


                    }
                });
            }


    }
}
