package com.example.dllo.food.homepagefragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.dllo.food.R;
import com.example.dllo.food.activity.homepageactivity.HomePageHomeNextActivity;
import com.example.dllo.food.adapter.HomePageHomeAdapter;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.bean.HomePageHomeBean;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;
import com.example.dllo.food.util.OnRecycleViewItemClick;

import java.util.ArrayList;
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
        homePageHomeAdapter.setOnRecycleViewItemClick(new OnRecycleViewItemClick() {
            @Override
            public void Onclick(int position) {
                Intent intent = new Intent(getActivity(), HomePageHomeNextActivity.class);
                ArrayList<String> data = new ArrayList<>();
                data.add(0,datas.get(position).getPublisher_avatar());
                data.add(1,datas.get(position).getPublisher());
                data.add(2,datas.get(position).getCard_image());
                data.add(3,datas.get(position).getLike_ct()+ "");
                intent.putStringArrayListExtra("NextActivity",data);
               startActivity(intent);
            }
        });
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
