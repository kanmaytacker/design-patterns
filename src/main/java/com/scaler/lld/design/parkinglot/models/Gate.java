package com.scaler.lld.design.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Gate {
    private String location;
    private Operator operator;
}
