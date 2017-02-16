package com.brady.simple.module.animal.interfaces.impl;

import com.brady.simple.module.animal.interfaces.IAnimal;
import com.brady.simple.module.animal.interfaces.IExtra;

/**
 * Created by ZhangYuanBo on 2017/2/16.
 *
 */
public class AnimalBean implements IAnimal {
    private  String name;
    private String food;
    private IExtra extra;


    public AnimalBean(String name, String food,IExtra extra) {
        this.name = name;
        this.food = food;
        this.extra = extra;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFood() {
        return food;
    }

    @Override
    public IExtra getExtra() {
        return extra;
    }
}
