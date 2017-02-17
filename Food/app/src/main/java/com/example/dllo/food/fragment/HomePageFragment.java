package com.example.dllo.food.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.food.R;
import com.example.dllo.food.adapter.HomePageAdapter;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.homepagefragment.HomePageEvaluationFragment;
import com.example.dllo.food.homepagefragment.HomePageFoodFragment;
import com.example.dllo.food.homepagefragment.HomePageHomeFragment;
import com.example.dllo.food.homepagefragment.HomePageKnowledgeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */

//逛吃界面的fragment
public class HomePageFragment extends BaseFragment {
   private String[]titles = new String[]{"首页","评测","知识","美食"};
    private List<Fragment> fragments;

    private HomePageAdapter homePageAdapter;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public int setLayout() {
        return R.layout.fragment_homepage;

    }

    @Override
    public void initView(View view) {
      tabLayout = (TabLayout) view.findViewById(R.id.homepager_tl);
     viewPager = (ViewPager) view.findViewById(R.id.homepager_vp);
     fragments = new ArrayList<>();
     fragments.add(new HomePageHomeFragment());
     fragments.add(new HomePageEvaluationFragment());
     fragments.add(new HomePageKnowledgeFragment());
     fragments.add(new HomePageFoodFragment());


    }

    @Override
    public void initData() {


     homePageAdapter = new
             HomePageAdapter(getChildFragmentManager(),fragments);
     viewPager.setAdapter(homePageAdapter);
     tabLayout.setupWithViewPager(viewPager);
     for (int i = 0; i < homePageAdapter.getCount(); i++) {
      tabLayout.getTabAt(i).setText(titles[i]);
     }
    }

}
