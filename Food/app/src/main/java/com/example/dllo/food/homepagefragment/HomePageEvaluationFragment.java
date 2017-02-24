package com.example.dllo.food.homepagefragment;

import android.content.Intent;
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

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageEvaluationFragment extends BaseFragment {
    private RecyclerView recyclerView;
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
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        homePageEvaluationAdapter.setOnRecycleViewItemClick(new OnRecycleViewItemClick() {
            @Override
            public void Onclick(int position) {
//                Toast.makeText(context, "点击事件 --- " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), HomePageEvaluationNextActivity.class);
               String link = datas.get(position).getLink();
                intent.putExtra("NextActivity",link);
                startActivity(intent);
            }
        });
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
