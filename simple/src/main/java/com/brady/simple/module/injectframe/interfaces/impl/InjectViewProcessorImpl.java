package com.brady.simple.module.injectframe.interfaces.impl;

import android.view.View;
import com.brady.simple.module.injectframe.annotation.InjectView;
import com.brady.simple.module.injectframe.interfaces.IProcessor;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

/**
 * Created by ZhangYuanBo on 2017/2/15.
 * 1. 首先要有一个rootView，用于findView
 * 2. 还需要有目标view的id,这个就是@InjectView中的值
 * 3. 需要目标对象
 * 4. 把从rootView找到的view赋值给目标对象的目标变量
 */

public class InjectViewProcessorImpl implements IProcessor<Field> {

    /** 如果当前这个AnnotatedElement实例加有InjectView注解，则返回true */
    public boolean accept(AnnotatedElement e) {
        return e.isAnnotationPresent(InjectView.class);
    }

    /**如果是返回true，说明这个它可以处理，则走到*/
    @Override
    public void process(Object object, View view, Field field) {
        InjectView iv = field.getAnnotation(InjectView.class);
        final int viewId = iv.value();
        final View v = view.findViewById(viewId);
        field.setAccessible(true);
        try {
            field.set(object, v);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}