package com.brady.simple.module.simple;

import android.content.Context;
import android.util.Log;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 */

public class Person {
    private Context mContext;

    public Person(Context context){
        mContext = context;
        Log.i("dagger","create");
    }
    public Person(String name){
        Log.i("dagger",name);
    }
}