package com.example.dllo.food.fragment;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.example.dllo.food.R;
import com.example.dllo.food.activity.LibraryNextActivity;
import com.example.dllo.food.activity.LibrarySearchActivity;
import com.example.dllo.food.activity.RegisterActivity;
import com.example.dllo.food.activity.homepageactivity.HomePageEvaluationNextActivity;
import com.example.dllo.food.adapter.homeadapter.LibraryAdapter;
import com.example.dllo.food.adapter.homeadapter.BrandLibraryAdapter;
import com.example.dllo.food.adapter.homeadapter.ShopLibraryAdapter;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.bean.CateGoriesBean;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;
import com.example.dllo.food.util.OnRecycleViewItemClick;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
//食物百科界面的fragment
public class LibraryFragment extends BaseFragment implements OnRecycleViewItemClick, View.OnClickListener {

    public static final String LIBRARY_URL = "http://food.boohee.com/fb/v1/categories/list";

    private RecyclerView recyclerView, brandRecyclerView, shopRecyclerView;
    private RadioButton analyzeRadioButton, seachRadioButton, scanRadioButton;
    private LibraryAdapter libraryAdapter;
    private BrandLibraryAdapter brandLibraryAdapter;
    private ShopLibraryAdapter shopLibraryAdapter;


    @Override
    public int setLayout() {
        return R.layout.fragment_library;
    }

    @Override
    public void initView(View view) {
        //绑定recyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.library_fragment_recyclerviewlibrary);
        brandRecyclerView = (RecyclerView) view.findViewById(R.id.library_fragment_recyclerviewbrand);
        shopRecyclerView = (RecyclerView) view.findViewById(R.id.library_fragment_recyclerviewshop);
        analyzeRadioButton = (RadioButton) view.findViewById(R.id.framgent_library_analyzeRadioButton);
        seachRadioButton = (RadioButton) view.findViewById(R.id.framgent_library_seachRadioButton);
        scanRadioButton = (RadioButton) view.findViewById(R.id.fragment_library_scanRadioButton);
        analyzeRadioButton.setOnClickListener(this);
        seachRadioButton.setOnClickListener(this);
        scanRadioButton.setOnClickListener(this);
    }

    @Override
    public void initData() {

        init();
        //libraryAdapter的RecycleView
        //设置recycleView的样式 网格式布局
        libraryAdapter = new LibraryAdapter(context);
        GridLayoutManager libraryManger = new GridLayoutManager(context, 3);
        libraryManger.setOrientation(GridLayoutManager.VERTICAL);
        //初始化适配器
        recyclerView.setLayoutManager(libraryManger);
        recyclerView.setAdapter(libraryAdapter);
        //添加监听事件
        libraryAdapter.setOnRecycleViewItemClick(this);


        // brandLibraryAdapter 的 RecyclerView
        //设置recycleView的样式 网格式布局
        brandLibraryAdapter = new BrandLibraryAdapter(context);
        GridLayoutManager brandManager = new GridLayoutManager(context, 3);
        brandManager.setOrientation(GridLayoutManager.VERTICAL);
        //初始化适配器
        brandRecyclerView.setLayoutManager(brandManager);
        brandRecyclerView.setAdapter(brandLibraryAdapter);
        //添加监听事件
        brandLibraryAdapter.setOnRecycleViewItemClick(this);

        // shopLibrayAdapter 的 RecyclerView
        //设置recycleView的样式 网格式布局
        shopLibraryAdapter = new ShopLibraryAdapter(context);
        GridLayoutManager shopManager = new GridLayoutManager(context, 3);
        shopManager.setOrientation(GridLayoutManager.VERTICAL);
        //初始化适配器
        shopRecyclerView.setLayoutManager(shopManager);
        shopRecyclerView.setAdapter(shopLibraryAdapter);
        //添加监听事件
        shopLibraryAdapter.setOnRecycleViewItemClick(this);

    }


    private void init() {
        NextTool.getInstance().startRequest(LIBRARY_URL, CateGoriesBean.class, new CallBack<CateGoriesBean>() {
            @Override
            public void onSuccess(CateGoriesBean response) {
                //遍历集合
                for (CateGoriesBean.GroupBean groupBean : response.getGroup()) {
                    switch (groupBean.getKind()) {
                        //找到对应的数据添加到适配器

                        case "group":
                            libraryAdapter.setDatas(groupBean.getCategories());
                            break;
                        case "brand":
                            brandLibraryAdapter.setDatas(groupBean.getCategories());
                            break;
                        case "restaurant":
                            shopLibraryAdapter.setDatas(groupBean.getCategories());
                            break;
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LibraryFragment", "首页食物百科请求异常" + e.getMessage());
            }
        });
    }

    @Override
    public void Onclick(int position) {
        Intent intent = new Intent(getActivity(), LibraryNextActivity.class);

        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.framgent_library_analyzeRadioButton:
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.framgent_library_seachRadioButton:
                Intent intent1 = new Intent(getActivity(), LibrarySearchActivity.class);
                startActivity(intent1);

                break;
            case R.id.fragment_library_scanRadioButton:

                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


                startActivity(intent2);
                break;

        }
    }
}
