package com.brady.simple.module.simple;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 */

@Qualifier  // 关键词
@Retention(RetentionPolicy.RUNTIME)  // 运行时仍可用
public @interface PersonForContext {
    // Context 对象的注解
}