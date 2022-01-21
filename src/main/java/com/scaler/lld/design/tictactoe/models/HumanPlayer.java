package com.scaler.lld.design.tictactoe.models;

import lombok.experimental.SuperBuilder;


@SuperBuilder(toBuilder = true)
public class HumanPlayer extends Player {
    
    private String userId;

    @Override
    public BoardCell move(Board board) {
        // TODO Auto-generated method stub
        return null;
    }
}
