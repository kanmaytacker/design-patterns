package com.scaler.lld.design.snakesladder.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private Colour colour;
    private List<Piece> pieces = new ArrayList<>();
}
