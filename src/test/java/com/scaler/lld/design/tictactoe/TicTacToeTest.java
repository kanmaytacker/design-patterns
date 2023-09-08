package com.scaler.lld.design.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import com.scaler.lld.design.tictactoe.factories.PlayerFactory;
import com.scaler.lld.design.tictactoe.models.BoardCell;
import com.scaler.lld.design.tictactoe.models.Game;
import com.scaler.lld.design.tictactoe.models.GameSymbol;
import com.scaler.lld.design.tictactoe.models.User;
import com.scaler.lld.design.tictactoe.strategies.DefaultPlayingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        this.game = createGame();
    }

    private Game createGame() {

        Game game = Game.getBuilder()
                .withDimension(3, 3)
                .withPlayer(
                        PlayerFactory.getHumanPlayer()
                                .user(new User())
                                .symbol(GameSymbol.O)
                                .build())
                .withPlayer(
                        PlayerFactory.getBotPlayer()
                                .playingStrategy(new DefaultPlayingStrategy())
                                .symbol(GameSymbol.X)
                                .build())
                .build();

        return game;
    }

    @Test
    public void testDimensions() {
       
        List<List<BoardCell>> cells = game.getBoard().getCells();
        assertEquals(3, cells.size(), "If board is created, number of rows should be equal to input");

        List<BoardCell> firstRow = cells.get(0);
        assertEquals(3, firstRow.size(), "If board is created, number of columns should be equal to input");

    }
}
