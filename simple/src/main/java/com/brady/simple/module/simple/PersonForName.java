package com.brady.simple.module.simple;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonForName {
    // name 对象的注解
}