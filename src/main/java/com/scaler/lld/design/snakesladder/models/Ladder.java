package com.scaler.lld.design.snakesladder.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ladder extends Cell {

    private int startIndex;
    private int endIndex;


    public Ladder(int startIndex, int endIndex) {
        super(CellType.LADDER);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }


    @Override
    public int nextLocation() {
        return endIndex;
    }
    
}
