package com.example.dllo.food.homepagefragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.food.R;
import com.example.dllo.food.activity.homepageactivity.HomePageEvaluationNextActivity;
import com.example.dllo.food.adapter.HomePageKnowledgeAdapter;
import com.example.dllo.food.bean.HomePageFoodBean;
import com.example.dllo.food.bean.HomePageKnowledgeBean;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;
import com.example.dllo.food.util.OnRecycleViewItemClick;
import com.example.dllo.food.util.Scorell;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class HomePageKnowledgeFragment extends BaseFragment{

    private RecyclerView recyclerView;
    private int pager = 1;
    private Receiver receiver;
    public static final String url =
            "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=3&per=10";
    private List<HomePageKnowledgeBean.FeedsBean> datas;
    private HomePageKnowledgeAdapter homePageKnowledgeAdapter;

    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public int setLayout() {
        return R.layout.fragment_homepage_knowledge;

    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.homepage_knowledge_fragment_rl);
        homePageKnowledgeAdapter = new HomePageKnowledgeAdapter(context);
        recyclerView.setAdapter(homePageKnowledgeAdapter);
    }

    @Override
    public void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        homePageKnowledgeAdapter.setOnRecycleViewItemClick(new OnRecycleViewItemClick() {
            @Override
            public void Onclick(int position) {
                Intent intent = new Intent(getActivity(), HomePageEvaluationNextActivity.class);
                String link  = datas.get(position).getLink();
                intent.putExtra("NextActivity",link);
                startActivity(intent);
            }
        });
        NextTool.getInstance().startRequest(url, HomePageKnowledgeBean.class, new CallBack<HomePageKnowledgeBean>() {


            @Override
            public void onSuccess(HomePageKnowledgeBean response) {
                datas = response.getFeeds();
                homePageKnowledgeAdapter.setDatas(datas);
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

            NextTool.getInstance().startRequest(url1, HomePageKnowledgeBean.class, new CallBack<HomePageKnowledgeBean>() {

                @Override
                public void onSuccess(HomePageKnowledgeBean respomse) {

                    datas.addAll(respomse.getFeeds());
                    homePageKnowledgeAdapter.setDatas(datas);
                }

                @Override
                public void onError(Throwable throwable) {


                }
            });
        }
    }
}
