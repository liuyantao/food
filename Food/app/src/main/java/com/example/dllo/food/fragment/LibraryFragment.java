package com.example.dllo.food.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import com.example.dllo.food.R;
import com.example.dllo.food.adapter.homeadapter.LibraryAdapter;
import com.example.dllo.food.adapter.homeadapter.BrandLibraryAdapter;
import com.example.dllo.food.adapter.homeadapter.ShopLibraryAdapter;
import com.example.dllo.food.base.BaseFragment;
import com.example.dllo.food.bean.CateGoriesBean;

import java.util.List;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
  //食物百科界面的fragment
public class LibraryFragment extends BaseFragment {

    private RecyclerView recyclerView, brandRecyclerView, shopRecyclerView;
    private List<CateGoriesBean.GroupBean.CategoriesBean> data, branddata, shopdata;
    private LibraryAdapter libraryAdapter;
    private BrandLibraryAdapter brandLibraryAdapter;
    private ShopLibraryAdapter shopLibraryAdapter;
    public static final int CATEGORIES_REQUESTCODE= 1;
    private RadioButton radioButton, analyzeRadioButton, scanRadioButton;

    @Override
    public int setLayout() {
        return R.layout.fragment_library;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {
// libraryAdapter = new LibraryAdapter(context);
//        recyclerView.setAdapter(libraryAdapter);
//        GridLayoutManager libraryManager = new GridLayoutManager(context, 3);
//        libraryManager.setOrientation(GridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(libraryManager);
//
//        // brandLibraryAdapter 的 RecyclerView
//        brandLibraryAdapter = new BrandLibraryAdapter(context);
//        brandRecyclerView.setAdapter(brandLibraryAdapter);
//        GridLayoutManager brandManager = new GridLayoutManager(context, 3);
//        brandManager.setOrientation(GridLayoutManager.VERTICAL);
//        brandRecyclerView.setLayoutManager(brandManager);
//
//        // shopLibrayAdapter 的 RecyclerView
//        shopLibraryAdapter = new ShopLibraryAdapter(context);
//        shopRecyclerView.setAdapter(shopLibraryAdapter);
//        GridLayoutManager shopManager = new GridLayoutManager(context, 3);
//        shopManager.setOrientation(GridLayoutManager.VERTICAL);
//        shopRecyclerView.setLayoutManager(shopManager);
//        data = new ArrayList<>();
//        branddata = new ArrayList<>();
//        shopdata = new ArrayList<>();
//
    }
}
