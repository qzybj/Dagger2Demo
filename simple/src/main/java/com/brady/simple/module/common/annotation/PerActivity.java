package com.brady.simple.module.common.annotation;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 * Activity 单例生命周期
 */

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PerActivity {
}
