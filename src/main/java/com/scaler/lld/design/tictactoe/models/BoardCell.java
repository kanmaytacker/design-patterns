package com.scaler.lld.design.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCell {
    private Integer x;
    private Integer y;
    private GameSymbol symbol;
}
