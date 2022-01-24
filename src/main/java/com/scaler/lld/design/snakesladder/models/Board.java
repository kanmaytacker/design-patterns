package com.scaler.lld.design.snakesladder.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private int size;
    private List<Cell> cells;
    private List<Snake> snakes;
    private List<Ladder> ladders;
}
