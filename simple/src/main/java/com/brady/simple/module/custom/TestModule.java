package com.brady.simple.module.custom;

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
    TestBean providesTestBean(){
        return new TestBean(name);
    }

}