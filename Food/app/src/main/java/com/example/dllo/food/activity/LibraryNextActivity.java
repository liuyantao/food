package com.example.dllo.food.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.food.R;
import com.example.dllo.food.adapter.LibraryNextListAdapter;

import com.example.dllo.food.adapter.LibraryNextGirdViewAdapter;
import com.example.dllo.food.adapter.homeadapter.BrandLibraryAdapter;
import com.example.dllo.food.base.BaseActivity;
import com.example.dllo.food.bean.CateGoriesBean;
import com.example.dllo.food.bean.LibraryNextBean;
import com.example.dllo.food.bean.LibraryNutritionBean;
import com.example.dllo.food.util.CallBack;
import com.example.dllo.food.util.Constant;
import com.example.dllo.food.util.NextTool;
import com.example.dllo.food.util.OnRecycleViewItemClick;

import java.util.ArrayList;
import java.util.List;

public class LibraryNextActivity extends BaseActivity {
    private TextView titleTv ;
    private ImageButton mImageButton;
    public static final String LIBRARY_URL = "http://food.boohee.com/fb/v1/categories/list";
    private ListView mListView;
    private Button mButton;
    private List<CateGoriesBean> datas;
    private List<LibraryNextBean.FoodsBean> data;
    private LibraryNutritionBean mBean;
    private LibraryNextBean mNextBean;
    private PopupWindow mPopupWindow;
    private int type;
    int id ;
    private BrandLibraryAdapter mBrandLibraryAdapter;
    private LibraryNextGirdViewAdapter girdadapter;
    private static final String TAG = "LibraryNextActivity";


    private LibraryNextListAdapter listAdapter;

    @Override
    protected int bindLayout() {
        return R.layout.activity_library_next;
    }

    @Override
    protected void initView() {
        mListView = (ListView) findViewById(R.id.activity_library_next_lv);


        listAdapter = new LibraryNextListAdapter(this);

        data = new ArrayList<>();
        mBean = new LibraryNutritionBean();
        mNextBean = new LibraryNextBean();
       girdadapter = new LibraryNextGirdViewAdapter(this);
        titleTv = (TextView) findViewById(R.id.activity_library_next_textview);
        mButton = (Button) findViewById(R.id.activity_library_next_tv);





        mImageButton = (ImageButton) findViewById(R.id.activity_library_next_ib);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent =  getIntent();
        String path = intent.getStringExtra("Categories");
        type =intent.getIntExtra("type",9);
        id = intent.getIntExtra("id",10);

        String title = intent.getStringExtra("title");
        titleTv.setText(title);
        initPopupWindow();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "789:" + 789);
                // 点击Btn显示内容
                // 为了防止重复点击出现,添加判断逻辑
                if (mPopupWindow.isShowing()) {
                    // 若未创建控件或者..控件未显示采取执行创建方法
                    mPopupWindow.dismiss();
                    Log.d(TAG, "456:" + 456);

                } else {
                    mPopupWindow.showAsDropDown(view, 100, 140);
                    Log.d(TAG, "123:" + 123);

                }



            }
        });


        // 添加popu里面文字的网络获取



//        Toast.makeText(this, "这是对应数据的解析网址" + path, Toast.LENGTH_SHORT).show();


        NextTool.getInstance().startRequest(path, LibraryNextBean.class, new CallBack<LibraryNextBean>() {
            @Override
            public void onSuccess(LibraryNextBean response) {
              data = response.getFoods();
//                Log.d(TAG, "response:" + data.size());
              listAdapter.setDatas(data);
                mListView.setAdapter(listAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });



    }

 private void initPopupWindow(){
     View girdView = LayoutInflater.from(this).inflate(R.layout.activity_library_next_girdview,null);
     GridView grid = (GridView) girdView.findViewById(R.id.activity_library_next_girdview);
     grid.setAdapter(girdadapter);
     mPopupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
     mPopupWindow.setContentView(girdView);
     girdadapter.setOnRecycleViewItemClick(new OnRecycleViewItemClick() {
         @Override
         public void Onclick(int position) {

             if (position == 0) {
                 int a = 2;
                 Ok(a);
             }
             if (position == 1) {
                 int a = 3;
                 Ok(a);
             }
             if (position == 2) {
                 int a = 4;
                 Ok(a);
             }
             if (position == 3) {
                 int a = 5;
                 Ok(a);
             }
             if (position == 4) {
                 int a = 6;
                 Ok(a);
             }
             if (position == 5) {
                 int a = 7;
                 Ok(a);
             }
             if (position == 6) {
                 int a = 8;
                 Ok(a);
             }
             if (position == 7) {
                 int a = 9;
                 Ok(a);
             }
             if (position == 8) {
                 int a = 10;
                 Ok(a);
             }
             if (position == 9) {
                 int a = 11;
                 Ok(a);
             }
             if (position == 10) {
                 int a = 12;
                 Ok(a);
             }
             if (position == 11) {
                 int a = 13;
                 Ok(a);
             }
             if (position == 12) {
                 int a = 14;
                 Ok(a);
             }
             if (position == 13) {
                 int a = 15;
                 Ok(a);
             }
             if (position == 14) {
                 int a = 16;
                 Ok(a);
             }
             if (position == 15) {
                 int a = 17;
                 Ok(a);
             }
             if (position == 16) {
                 int a = 18;
                 Ok(a);
             }
             if (position == 17) {
                 int a = 19;
                 Ok(a);
             }
             if (position == 18) {
                 int a = 20;
                 Ok(a);
             }
             if (position == 19) {
                 int a = 21;
                 Ok(a);
             }
             if (position == 20) {
                 int a = 22;
                 Ok(a);
             }
             if (position == 21) {
                 int a = 23;
                 Ok(a);
             }


             mPopupWindow.dismiss();


         }
     });



 }



    private  void Ok (int b) {
        if (1 == type) {
            NextTool.getInstance().startRequest(Constant.CLASS + id + Constant.ORDER + b + Constant.IFICATION, LibraryNextBean.class, new CallBack<LibraryNextBean>() {
                @Override
                public void onSuccess(LibraryNextBean response) {
                    data = response.getFoods();
//                Log.d(TAG, "response:" + data.size());
                    listAdapter.setDatas(data);
                    mListView.setAdapter(listAdapter);

                }

                @Override
                public void onError(Throwable e) {

                }
            });

        }
        if (2 == type) {
            NextTool.getInstance().startRequest(Constant.POPULAR + id + Constant.ORDER + b + Constant.IFICATION, LibraryNextBean.class, new CallBack<LibraryNextBean>() {
                @Override
                public void onSuccess(LibraryNextBean response) {
                    data = response.getFoods();
//                Log.d(TAG, "response:" + data.size());
                    listAdapter.setDatas(data);
                    mListView.setAdapter(listAdapter);

                }

                @Override
                public void onError(Throwable e) {

                }
            });

        }
        if (3 == type) {
            NextTool.getInstance().startRequest(Constant.CHAIN + id + Constant.ORDER + b + Constant.IFICATION, LibraryNextBean.class, new CallBack<LibraryNextBean>() {
                @Override
                public void onSuccess(LibraryNextBean response) {
                    data = response.getFoods();
//                Log.d(TAG, "response:" + data.size());
                    listAdapter.setDatas(data);
                    mListView.setAdapter(listAdapter);

                }

                @Override
                public void onError(Throwable e) {

                }
            });

        }

    }
    @Override
    protected void bindEvent() {

    }
}
