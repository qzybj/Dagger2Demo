package com.brady.simple.module.injectframe.annotation;

import android.support.annotation.IdRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ZhangYuanBo on 2017/2/15.
 * 1.我需要知道要绑定点击事件的view的id，这个在@OnClick中的value指定
 2.和之前的一样，也需要一个根view来拿到具体的view
 3.要注入的对象，这个是必须的，
 4.要把某个方法绑定为点击事件的回调，我还要知道是哪个方法
 5.ok上述的条件都满足后，就可以拿到find来的view并设置setOnClickListener,在收到回调的时候，去调用指定方法，来实现间接的绑定
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnClick {
    @IdRes int[] value();
}
