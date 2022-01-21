package com.scaler.lld.design.tictactoe.models;

import com.scaler.lld.design.tictactoe.strategies.PlayingStrategy;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Bot extends Player {

    private PlayingStrategy playingStrategy;
    @Override
    public BoardCell move(Board board) {
        // TODO Auto-generated method stub
        return null;
    }

}
