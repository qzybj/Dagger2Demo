package com.brady.simple.module.animal;


import com.brady.simple.module.animal.interfaces.IExtra;
import com.brady.simple.module.animal.interfaces.impl.ExtraBean;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangYuanBo on 2017/2/16.
 */
@Module
public class ExtraModule {

    @Named("Sheep")
    @Provides
    public IExtra providesSheep(){
        return new ExtraBean(3.0,40.0,1.0,80.0);
    }

    @Named("Tiger")
    @Provides
    public IExtra providesTiger(){
        return new ExtraBean(3.0,200.0,1.5,120.0);
    }
}