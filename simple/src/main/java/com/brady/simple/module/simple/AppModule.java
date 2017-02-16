package com.brady.simple.module.simple;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 */

@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context){
        mContext = context;
    }

    @Provides
    Context providesContext(){
        // 提供Context对象　
        return mContext;
    }

}