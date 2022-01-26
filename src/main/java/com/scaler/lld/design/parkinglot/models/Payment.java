package com.scaler.lld.design.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    private String tickeId;
    private Integer amount;
    private String mode;
}
