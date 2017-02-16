package com.brady.simple.module.animal;


import javax.inject.Named;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangYuanBo on 2017/2/16.
 */
@Module
public class FoodModule {

    @Named("Sheep")
    @Provides
    public String providesGrass(){
        return "Grass";
    }

    @Named("Tiger")
    @Provides
    public String providesMeat(){
        return "Meat";
    }
}