package com.scaler.lld.design.snakesladder.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Snake extends Cell {

    private int startIndex;
    private int endIndex;

    
    public Snake(CellType cellType, int startIndex, int endIndex) {
        super(cellType);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public int nextLocation() {
        return endIndex;
    }

}
