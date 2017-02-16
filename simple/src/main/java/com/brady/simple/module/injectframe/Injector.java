package com.brady.simple.module.injectframe;

import android.app.Activity;
import android.view.View;

import com.brady.simple.module.injectframe.interfaces.IProcessor;
import com.brady.simple.module.injectframe.interfaces.impl.InjectViewProcessorImpl;
import com.brady.simple.module.injectframe.interfaces.impl.OnClickProcessorImpl;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhangYuanBo on 2017/2/15.
 */
public class Injector {

    private static List<? extends IProcessor<? extends AccessibleObject>> chain =
            Arrays.asList(new InjectViewProcessorImpl(), new OnClickProcessorImpl());

    public static void inject(Activity act) {
        inject(act, act.getWindow().getDecorView());
    }

    public static void inject(Object obj, View rootView) {
        final Class<?> aClass = obj.getClass();
        final Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f : declaredFields) {
            doChain(obj, f, rootView);
        }
        final Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            doChain(obj, m, rootView);
        }
    }

    //这个就是前面已经说过的，把每个遍历到的方法或者属性，甚至是构造方法，类等等通过处理器链来询问这个注解你accept吗？接受则交给它来处理，
    private static void doChain(Object obj, AccessibleObject ao, View rootView) {
        for (IProcessor p : chain) {
            if (p.accept(ao)) p.process(obj, rootView, ao);
        }
    }
}