package com.brady.simple.module.animal;


import com.brady.simple.module.animal.interfaces.IExtra;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by ZhangYuanBo on 2017/2/16.
 */
@Component(modules = {ExtraModule.class})
public interface ExtraComponent {
    @Named("Sheep")
    IExtra providesSheep();

    @Named("Tiger")
    IExtra providesTiger();

}
