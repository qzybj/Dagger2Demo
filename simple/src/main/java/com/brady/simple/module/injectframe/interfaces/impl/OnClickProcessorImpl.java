package com.brady.simple.module.injectframe.interfaces.impl;

import android.view.View;
import com.brady.simple.module.injectframe.annotation.OnClick;
import com.brady.simple.module.injectframe.interfaces.IProcessor;

import java.lang.ref.WeakReference;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * Created by ZhangYuanBo on 2017/2/15.
 */
public class OnClickProcessorImpl implements IProcessor<Method> {
    /**这个很简单，就是告诉管理器我响应OnClick注解*/
    @Override
    public boolean accept(AnnotatedElement e) {
        return e.isAnnotationPresent(OnClick.class);
    }

    /**
     * 这个也还是一样，
     * 1.先拿到具体的注解对象 ，并拿到里面的值
     * 2.因为存在多个id绑定到一个方法上的情况，所以一个循环不可少
     * 3.就是拿到view,设置监听事件
     * 4.但是，这个InvokeOnClickListener是个什么东西呢？
     */
    @Override
    public void process(Object object,View view, Method method) {
        final OnClick oc = method.getAnnotation(OnClick.class);
        final int[] value = oc.value();
        for (int id : value) {
            view.findViewById(id).setOnClickListener(new InvokeOnClickListener(method,object));
        }
    }

    private static class InvokeOnClickListener implements View.OnClickListener {

        public Method method;
        public WeakReference<Object> obj;
        private boolean hasParam;

        InvokeOnClickListener(Method m, Object object) {
            this.method = m;
            this.obj = new WeakReference<Object>(object);
            final Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes == null || parameterTypes.length == 0) {
                hasParam = false;
            } else if (parameterTypes.length > 1 || !View.class.isAssignableFrom(parameterTypes[0])) {
                throw new IllegalArgumentException(String.format("%s方法只能拥有0个或一个参数，且只接收View", m.getName()));
            } else {
                hasParam = true;
            }
        }

        @Override
        public void onClick(View v) {
            //点击事件触发了
            Object o = obj.get(); //为什么要用一个WeakReference,其实没有必要，因为activity消亡了，view也就消亡了，这个循环引用似乎不存在，但是我还是写下，假如有假如呢。
            if (o != null) {
                try {
                    if (hasParam) { //有参数，就把view传过去
                        method.invoke(o, v);
                    } else { //没有参数就直接调
                        method.invoke(o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}