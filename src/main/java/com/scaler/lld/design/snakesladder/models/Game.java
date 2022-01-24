package com.scaler.lld.design.snakesladder.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>();
    private List<Dice> dices = new ArrayList<>();
}
