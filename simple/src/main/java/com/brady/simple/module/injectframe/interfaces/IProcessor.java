package com.brady.simple.module.injectframe.interfaces;

import android.view.View;
import java.lang.reflect.AnnotatedElement;

/**
 * Created by ZhangYuanBo on 2017/2/15.
 *
 */

public interface IProcessor<T extends AnnotatedElement> {

    /**  每个不同的处理器都会通过这个方法来告诉最终的调度者，这个注解是否由我来处理
     * 在Java中，Field,Method,Constructor…一切可注解的对象都实现了AnnotatedElement接口。ProcessorIntf用于给解析器提供一系列通用行为：*/
     boolean accept(AnnotatedElement t);

    /** 这样看来，可以把处理行为抽象成这几个参数？(无论是@InjectView,@InjectString,@OnClick等等任何注入的操作，是不是应该都需要这几个条件呢)
     *第一个object是目标对象，
     *第二个view是根view
     *第三个是加上注解的那个东西
     */
     void process(Object object, View view, T t);
}