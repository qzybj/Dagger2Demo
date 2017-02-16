package com.brady.simple.module.custom;


import dagger.Component;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 */
@Component(modules = TestModule.class )
public interface TestComponent {

    TestBean providesTestBean();
}
