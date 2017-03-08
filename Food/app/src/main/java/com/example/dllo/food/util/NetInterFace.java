package com.example.dllo.food.util;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public interface NetInterFace {

    void startRequest(String url,CallBack<String> callBack);
    <T> void startRequest(String url,Class<T> tClass,CallBack<T> callBack);
}
