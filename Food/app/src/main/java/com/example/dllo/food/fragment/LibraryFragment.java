package com.example.dllo.food.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import com.example.dllo.food.R;
import com.example.dllo.food.adapter.homeadapter.LibraryAdapter;
import com.example.dllo.food.adapter.homeadapter.BrandLibraryAdapter;
import com.example.dllo.food.adapter.homeadapter.ShopLibraryAdapter;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.bean.CateGoriesBean;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.NextTool;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
//食物百科界面的fragment
public class LibraryFragment extends BaseFragment {

    public static final String LIBRARY_URL = "http://food.boohee.com/fb/v1/categories/list";

    private RecyclerView recyclerView, brandRecyclerView, shopRecyclerView;
    private List<CateGoriesBean.GroupBean.CategoriesBean> data, branddata, shopdata;
    private LibraryAdapter libraryAdapter;
    private BrandLibraryAdapter brandLibraryAdapter;
    private ShopLibraryAdapter shopLibraryAdapter;
//    public static final int CATEGORIES_REQUESTCODE = 1;
//    private RadioButton radioButton, analyzeRadioButton, scanRadioButton;

    @Override
    public int setLayout() {
        return R.layout.fragment_library;
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.library_fragment_recyclerviewlibrary);
        brandRecyclerView = (RecyclerView) view.findViewById(R.id.library_fragment_recyclerviewbrand);
        shopRecyclerView = (RecyclerView) view.findViewById(R.id.library_fragment_recyclerviewshop);
    }

    @Override
    public void initData() {

        init();

        libraryAdapter = new LibraryAdapter(context);
        GridLayoutManager libraryManger = new GridLayoutManager(context, 3);
        libraryManger.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(libraryManger);
        recyclerView.setAdapter(libraryAdapter);


        // brandLibraryAdapter 的 RecyclerView
        brandLibraryAdapter = new BrandLibraryAdapter(context);
        GridLayoutManager brandManager = new GridLayoutManager(context, 3);
        brandManager.setOrientation(GridLayoutManager.VERTICAL);
        brandRecyclerView.setLayoutManager(brandManager);
        brandRecyclerView.setAdapter(brandLibraryAdapter);

        // shopLibrayAdapter 的 RecyclerView
        shopLibraryAdapter = new ShopLibraryAdapter(context);
        GridLayoutManager shopManager = new GridLayoutManager(context, 3);
        shopManager.setOrientation(GridLayoutManager.VERTICAL);
        shopRecyclerView.setLayoutManager(shopManager);
        shopRecyclerView.setAdapter(shopLibraryAdapter);



    }

    private void init() {
        NextTool.getInstance().startRequest(LIBRARY_URL, CateGoriesBean.class, new CallBack<CateGoriesBean>() {
            @Override
            public void onSuccess(CateGoriesBean response) {
                //遍历集合
                for (CateGoriesBean.GroupBean groupBean : response.getGroup()) {
                    switch (groupBean.getKind()) {
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
}
