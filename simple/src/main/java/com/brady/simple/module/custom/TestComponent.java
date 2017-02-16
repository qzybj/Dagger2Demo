package com.brady.simple.module.custom;


import android.content.Context;

import com.brady.simple.MainActivity;
import dagger.Component;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 */
@Component(modules = TestModule.class )
public interface TestComponent {

    void injectTest(Context con);
}
