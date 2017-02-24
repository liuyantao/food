package com.example.dllo.food.util;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
//存放网络请求中用到的所有接口
public class Contant {
    // 基础域名部分 所有的接口都需要拼接的共有部分
    public static final String BASE_URL = "http://food.boohee.com/fb/v1/";
    public static final String CATEGORIES = BASE_URL + "categories/list";
    public static final String FEEDS = BASE_URL + "feeds/category_feed?page=1&category=1&per=10";
    public static final String FEED_REVIEW = BASE_URL + "feeds/category_feed?page=1&category=2&per=10";
    public static final String FEED_LORE = BASE_URL + "feeds/category_feed?page=1&category=3&per=10";
    public static final String FEED_CATE = BASE_URL + "feeds/category_feed?page=1&category=4&per=10";
    private static int index = 0;
    public static final int FEED_REQUESTCODE = index++;
    public static final int FEEDLORE_REQUESTCODE = index++;
    public static final int FEEDCATE_REQUESTCODE = index++;
}
