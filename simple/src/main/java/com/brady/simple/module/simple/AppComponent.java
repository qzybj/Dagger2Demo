package com.brady.simple.module.simple;


import android.content.Context;

import dagger.Component;

/**
 *
 * 全局的Component 组件
 * Created by ZhangYuanBo on 2017/2/14.
 */

@Component(modules = AppModule.class)
public interface AppComponent {

    // 向其下层提供Context 对象
    Context proContext();
}