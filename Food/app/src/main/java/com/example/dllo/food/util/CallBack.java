package com.example.dllo.food.util;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public interface CallBack <T>{
    //请求成功过得回调形参就是我们最后解析好的数据
    //因为不知道具体的类型所以我们用T泛型代替
    void onSuccess(T response);
    //失败的回调   形参中我们填写的是异常对象
    void onError(Throwable e);
}
