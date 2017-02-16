package com.brady.simple.module.animal.interfaces.impl;

import com.brady.simple.module.animal.interfaces.IExtra;

/**
 * Created by ZhangYuanBo on 2017/2/16.
 */

public class ExtraBean implements IExtra {
    private Double speed =0.0;
    private Double weight =0.0;
    private Double height =0.0;
    private Double strength =0.0;

    public ExtraBean(Double speed, Double weight, Double height, Double strength) {
        this.speed = speed;
        this.weight = weight;
        this.height = height;
        this.strength = strength;
    }

    public Double getStrength() {
        return strength;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getSpeed() {
        return speed;
    }


}
