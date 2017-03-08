package com.example.dllo.food.util;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class OkTool implements NetInterFace {
    private Gson mGson;
    private Handler mHandler = new Handler(Looper.myLooper());
    private OkHttpClient mOkHttpClient;
    public OkTool(){
        mGson = new Gson();

        mOkHttpClient = new OkHttpClient.Builder().retryOnConnectionFailure(true)
                .connectTimeout(5, TimeUnit.SECONDS)
                //缓存
                .cache(new Cache(Environment.getExternalStorageDirectory(),10 * 1024))
                .build();
    }
    @Override
    public void startRequest(String url, final CallBack<String> callBack) {
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(str);
                    }
                });
            }
        });

    }
    //请求不确定方法的
    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final CallBack<T> callBack) {
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String str = response.body().string();
                final T result = mGson.fromJson(str,tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });
            }
        });
    }

}
