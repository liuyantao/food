package com.example.dllo.food.util;

/**
 * ✎﹏﹏﹏.₯㎕*﹏﹏﹏
 * 　　忍把浮名，
 * 　　　　换了浅斟低唱。
 * 　　　　 ﹏﹏﹏♥♥刘延涛✍♥♥﹏﹏
 */
public class NextTool implements NetInterFace{
    private static NextTool ourInstance ;
    private NetInterFace mInterface;

    public static NextTool getInstance() {
        //双重体验锁单例模式
        if (ourInstance == null){
            synchronized (NextTool.class){
                if (ourInstance == null){
                    ourInstance = new NextTool();
                }
            }
        }
        return ourInstance;
    }

    private NextTool() {
        mInterface = new OkTool();
    }

    @Override
    public void startRequest(String url, CallBack<String> callBack) {
        mInterface.startRequest(url,callBack);
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, CallBack<T> callBack) {
        mInterface.startRequest(url,tClass,callBack);
    }
}
