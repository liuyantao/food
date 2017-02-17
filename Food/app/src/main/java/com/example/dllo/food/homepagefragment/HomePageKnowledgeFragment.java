package com.example.dllo.food.homepagefragment;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.food.R;
import com.example.dllo.food.adapter.HomePageEvaluationAdapter;
import com.example.dllo.food.adapter.HomePageKnowledgeAdapter;
import com.example.dllo.food.bean.HomePageEvaluationBean;
import com.example.dllo.food.bean.HomePageKnowledgeBean;
import com.example.dllo.food.fragment.BaseFragment;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageKnowledgeFragment extends BaseFragment{

    private RecyclerView recyclerView;
    public static final String url =
            "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=3&per=10";
    private List<HomePageKnowledgeBean.FeedsBean> datas;
    private HomePageKnowledgeAdapter homePageKnowledgeAdapter;

    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public int setLayout() {
        return R.layout.homepage_knowledge_fragment;

    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.homepage_knowledge_fragment_rl);
        home = new HomePageEvaluationAdapter(context);
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
