package com.brady.simple.module.custom;

import com.brady.simple.module.simple.PersonForContext;
import com.brady.simple.module.simple.PersonForName;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 */
@Module
public class TestModule {

    private String name;

    public TestModule(String name){
        this.name = name;
    }

    @Provides
    String providesName(){
        return name;
    }

    @PersonForContext
    @Provides
    TestBean providesTestBean(String name){
        return new TestBean(name);
    }

}