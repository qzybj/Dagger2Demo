package com.brady.simple.module.simple;

import android.content.Context;
import dagger.Module;
import dagger.Provides;


/**
 *
 * 下层Module类
 * Created by ZhangYuanBo on 2017/2/14.
 */
@Module
public class ActivityMoudule {

    @PersonForContext
    @Provides
    Person providePerson(Context context){
        //此方法需要Context 对象
        return new Person(context);
    }

    @PersonForName
    @Provides
    Person providePersonName(){
        //此方法需要name
        return new Person("1234");
    }
}