package com.brady.simple;

import android.app.Application;


/**
 * Created by ZhangYuanBo on 2017/2/14.
 */
public class MyApplication extends Application {

    private static Application instance;


    public static Application instance(){
       return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
