package com.scaler.lld.design.tictactoe.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
public abstract class Player {
    
    private GameSymbol symbol;

    public abstract BoardCell move(Board board);
}
