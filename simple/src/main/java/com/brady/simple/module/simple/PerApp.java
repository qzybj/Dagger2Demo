package com.brady.simple.module.simple;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ZhangYuanBo on 2017/2/14.
 * 全局的生命周期单例
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApp {

}