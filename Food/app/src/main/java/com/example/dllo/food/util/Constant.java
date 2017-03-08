package com.example.dllo.food.util;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 *
 *
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class Constant {
    // 基础域名部分  所有的接口都需要拼接的公有部分
    public static final String BASE_URL="http://food.boohee.com/fb/v1/";

    // 获取食物百科列表的接口
    public static final String CHANNELS=BASE_URL+"categories/list";
    // 营养素
    public static final String NUTRITION = "http://food.boohee.com/fb/v1/foods/sort_types";

    // 第二页首页接口
    public static final String CATEGORY="http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=1&per=10\n";
    // 测评接口
    public static final String EVALIATION = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=2&per=10";
    // 知识接口
    public static final String KNOW = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=3&per=10\n";
    // 美食
    public static final String FOOD = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=4&per=10";








    // 食物分类
    public static final String CLASS = "http://food.boohee.com/fb/v1/foods?kind=group&value=";
    public static final String IFICATION = "&page=1&order_asc=0&token=&user_key=&app_version=2.6&app_device=Android&os_version=5.0.2&phone_model=Redmi+Note+3&channel=xiaomi";
    // 排序
    public static final String ORDER = "&order_by=";

    // 热门品牌
    public static final String POPULAR = "http://food.boohee.com/fb/v1/foods?kind=brand&value=";
//    public static final String BRANDS = "&order_by=1&page=1&order_asc=0&token=&user_key=&app_version=2.6&app_device=Android&os_version=5.0.2&phone_model=Redmi+Note+3&channel=xiaomi";


    // 连锁餐饮
    public static final String CHAIN = "http://food.boohee.com/fb/v1/foods?kind=restaurant&value=";
//    public static final String CATERING = "&order_by=1&page=1&order_asc=0&token=&user_key=&app_version=2.6&app_device=Android&os_version=5.0.2&phone_model=Redmi+Note+3&channel=xiaomi";


    // 搜索
    public static final String SEARCH ="public static final String CHAIN = ";
    public static final String SE = "&token=&user_key=&app_version=2.6&app_device=Android&os_version=5.0.2&phone_model=Redmi+Note+3&channel=xiaomi";


    public static  int index =0;
    public static final int CHANNELSCOAD = index++;
    public static final int CATEGORYCOAD = index++;
    public static final int EVALIATIONCOAD = index++;
    public static final int KNOWCOAD = index++;
    public static final int FOODCOAD = index++;
    public static final int CLASSIFICATION = index++;
    public static final int NUTRITIONCOAD = index++;
    public static final int SEARCHCOAD = index++;
}
