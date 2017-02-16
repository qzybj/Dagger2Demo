package com.brady.simple.module.animal;

import android.content.Context;

import com.brady.simple.module.animal.interfaces.IAnimal;
import com.brady.simple.module.animal.interfaces.IExtra;
import com.brady.simple.module.animal.interfaces.impl.AnimalBean;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ZhangYuanBo on 2017/2/16.
 */
@Module
public class AnimalModule {
    private Context con;

    public AnimalModule(Context con){
        this.con = con;
    }

    @Provides
    public Context providesContext(){
        return con;
    }

    @Named("Sheep")
    @Provides
    public IAnimal providesSheep(@Named("Sheep")String food,@Named("Sheep")IExtra extra){
        return new AnimalBean("Sheep",food,extra);
    }

    @Named("Tiger")
    @Provides
    public IAnimal providesTiger(@Named("Tiger")String food,@Named("Tiger")IExtra extra){
        return new AnimalBean("Tiger",food,extra);
    }
}