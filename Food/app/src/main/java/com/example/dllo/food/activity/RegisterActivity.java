package com.example.dllo.food.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.dllo.food.R;
import com.example.dllo.food.base.BaseActivity;
import com.example.dllo.food.fragment.MyFragment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

import static android.R.attr.action;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class RegisterActivity extends BaseActivity{
    private  Button button;
    private ImageButton mImageButtonqq,mImageButtonweibo;

    //登录界面
    @Override
    protected int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        mImageButtonqq = (ImageButton) findViewById(R.id.register_qq);
        mImageButtonweibo = (ImageButton) findViewById(R.id.register_weibo);
        button = (Button) findViewById(R.id.activity_register_tv);
        
        mImageButtonweibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareSDK.initSDK(RegisterActivity.this);

                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行

                String accessToken = weibo.getDb().getToken(); // 获取授权token
                String openId = weibo.getDb().getUserId(); // 获取用户在此平台的ID
                String nickname = weibo.getDb().getUserName(); // 获取用户昵称
                weibo.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();
                    }

                    @Override
                    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
                        arg0.getDb().exportData();
                    }

                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub

                    }
                });
//authorize与showUser单独调用一个即可
                weibo.authorize();//单独授权,OnComplete返回的hashmap是空的
                weibo.showUser(null);//授权并获取用户信息
                finish();

//移除授权
//weibo.removeAccount(true);

            }
        });
        mImageButtonqq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareSDK.initSDK(RegisterActivity.this);
                Platform qq = ShareSDK.getPlatform(QQ.NAME);
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行

                String accessToken = qq.getDb().getToken(); // 获取授权token
                String openId = qq.getDb().getUserId(); // 获取用户在此平台的ID
                String nickname = qq.getDb().getUserName(); // 获取用户昵称
                qq.setPlatformActionListener(new PlatformActionListener() {

                    @Override
                    public void onError(Platform arg0, int arg1, Throwable arg2) {
                        // TODO Auto-generated method stub
                        arg2.printStackTrace();
                    }

                    @Override
                    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                        // TODO Auto-generated method stub
                        //输出所有授权信息
                        Iterator ite =arg2.entrySet().iterator();
                        while (ite.hasNext()) {
                            Map.Entry entry = (Map.Entry)ite.next();
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            System.out.println(key+"： "+value);
                        }
                        if (action == Platform.ACTION_USER_INFOR) {
                            PlatformDb platDB = arg0.getDb();//获取数平台数据DB
                            //通过DB获取各种数据
//                            String usertoken = platDB.getToken();
//
//                            String usergender = platDB.getUserGender();
//                            String usericon =  platDB.getUserIcon();
//                            String userid = platDB.getUserId();
//                            String userName = platDB.getUserName();




                        }


                    }

                    @Override
                    public void onCancel(Platform arg0, int arg1) {
                        // TODO Auto-generated method stub

                    }
                });
//authorize与showUser单独调用一个即可
//                qq.authorize();//单独授权,OnComplete返回的hashmap是空的
                qq.showUser(null);//授权并获取用户信息
                finish();
//移除授权
 qq.removeAccount(true);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }
}
