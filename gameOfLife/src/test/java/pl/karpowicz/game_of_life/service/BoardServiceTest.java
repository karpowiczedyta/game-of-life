package pl.karpowicz.game_of_life.service;

import org.junit.jupiter.api.Test;
import pl.karpowicz.game_of_life.model.Board;
import pl.karpowicz.game_of_life.model.Cell;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardServiceTest {


    @Test
    void shoudReturnAmountOfAliveCells() {
        //given
        Cell[][] cells = {{new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(true), new Cell(true), new Cell(true), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)}};
        Board board = new Board(cells);
        BoardService boardService = new BoardService();
        int i = 1;
        int j = 1;

        //when
        int amountOfLifeCells = boardService.aliveCells(i, j, cells);

        //then
        assertEquals(amountOfLifeCells, 2);

    }

    @Test
    void shouldChangeStateCells() {

        //given
        Cell[][] cells = {{new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(true), new Cell(true), new Cell(true), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)}};

        BoardService boardService = new BoardService();
        Board board = new Board(cells);

        //when
        Board newBoard = boardService.changeStateCell(board);

        //then
        assertArrayEquals(cells, newBoard.getCells());
        assertEquals(newBoard.getCells()[2][1].getNewState(), false);
        assertEquals(newBoard.getCells()[2][2].getNewState(), true);
        assertEquals(newBoard.getCells()[2][3].getNewState(), false);
        assertEquals(newBoard.getCells()[1][2].getNewState(), true);
        assertEquals(newBoard.getCells()[3][2].getNewState(), true);
    }

    @Test
    void shouldApplayChangedStateOfCellsOnTheBoard() {

        //given
        Cell[][] cells = {{new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(true), new Cell(false), new Cell(false)},
                {new Cell(false), new Cell(false), new Cell(false), new Cell(false), new Cell(false)}};
        BoardService boardService = new BoardService();
        Board board = new Board(cells);

        //when
        Board activateBoard = boardService.applayChangedStateOfCellsOnTheBoard(board);

        //then
        assertArrayEquals(cells, activateBoard.getCells());

    }


}