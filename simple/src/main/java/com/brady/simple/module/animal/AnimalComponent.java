package com.brady.simple.module.animal;


import com.brady.simple.MainActivity;
import dagger.Component;


/**
 * Created by ZhangYuanBo on 2017/2/16.
 */
@Component(dependencies = {FoodComponent.class,ExtraComponent.class},modules = {AnimalModule.class})
public interface AnimalComponent {

    void inject(MainActivity activity);
}