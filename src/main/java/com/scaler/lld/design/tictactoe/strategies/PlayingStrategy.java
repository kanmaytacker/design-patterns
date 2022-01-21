package com.scaler.lld.design.tictactoe.strategies;

import com.scaler.lld.design.tictactoe.models.Board;
import com.scaler.lld.design.tictactoe.models.BoardCell;

public interface PlayingStrategy {
    
    public BoardCell play(Board  board);
}
