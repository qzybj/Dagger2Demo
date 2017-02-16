package com.brady.simple.module.animal;


import javax.inject.Named;
import dagger.Component;

/**
 * Created by ZhangYuanBo on 2017/2/16.
 */
@Component(modules = {FoodModule.class})
public interface FoodComponent {
    // ★前面说过这里的这个方法是可以不写的，但如果你想让别的Component依赖这个Component就必须写，
    // 不写这个方法，就意味着没有向外界，暴露这个依赖
    @Named("Sheep")
    String providesGrass();

    @Named("Tiger")
    String providesMeat();

//    void inject(Object o);//这里没有想注入到那个类中，可以不写inject方法
}
