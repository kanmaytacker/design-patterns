package com.scaler.lld.design.structural.decorator.pizza;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseDecorator implements Pizza {
    protected Pizza nextLayer;
}
