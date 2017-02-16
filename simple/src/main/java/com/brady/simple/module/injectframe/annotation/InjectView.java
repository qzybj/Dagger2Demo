package com.brady.simple.module.injectframe.annotation;

import android.support.annotation.IdRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ZhangYuanBo on 2017/2/15.
 * 1.先拿到具体的注解类，并拿到里面的值比如R.id.txt等
 * 2.从跟view中findViewById拿到指定的view
 * 3.为防止目标属性是private的，将可访问设置为true,并赋值
 * ok,这样一个view就被注入到目标属性中了
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface InjectView {
     @IdRes int value();
}
