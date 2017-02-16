package com.brady.simple.module.custom;

import android.util.Log;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 */

public class TestBean {
    private String name;

    public TestBean(String name){
        this.name = name;
    }

    public void show(){
        Log.i("dagger","show "+name);
    }
}
