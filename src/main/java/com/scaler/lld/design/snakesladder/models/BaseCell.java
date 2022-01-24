package com.scaler.lld.design.snakesladder.models;

public class BaseCell extends Cell {

    public BaseCell() {
        super(CellType.BASE);
    }

    @Override
    public int nextLocation() {
        return getIndex();
    }

}
