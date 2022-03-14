package pl.karpowicz.game_of_life.service;

import org.springframework.stereotype.Component;
import pl.karpowicz.game_of_life.model.Board;
import pl.karpowicz.game_of_life.model.Cell;

@Component
public class BoardService {

    public BoardService() {
    }

    public Board nextStep(Board board) {

        changeStateCell(board);
        return applayChangedStateOfCellsOnTheBoard(board);

    }

    public Board changeStateCell(Board board) {

        Cell[][] cells = board.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {

                int amountAliveCells = aliveCells(row, column, cells);

                Cell cell = cells[row][column];

                if (amountAliveCells < 2) {
                    cell.changeState(false);
                } else if (amountAliveCells > 3) {
                    cell.changeState(false);
                } else if (amountAliveCells == 2) {
                    cell.changeState(cells[row][column].getState());
                } else if (amountAliveCells == 3) {
                    cell.changeState(true);
                }
            }
        }
        return board;
    }


    public int aliveCells(int row, int column, Cell[][] cells) {

        int j = 0;


        int howManyTimes = 0;

        if (column != 0) {
            if (cells[row][column - 1].getState()) {
                howManyTimes++;
            }
        }

        if (column != cells[row].length - 1) {
            if (cells[row][column + 1].getState()) {
                howManyTimes++;
            }
        }

        if (row != 0) {
            if (cells[row - 1][column].getState()) {
                howManyTimes++;
            }
        }

        if (row != 0 && column != 0) {

            if (cells[row - 1][column - 1].getState()) {

                howManyTimes++;
            }

        }

        if (row != 0 && column != cells[row].length - 1) {

            if (cells[row - 1][column + 1].getState()) {

                howManyTimes++;
            }

        }

        if (row != cells.length - 1) {

            if (cells[row + 1][column].getState()) {

                howManyTimes++;
            }

        }


        if (row != cells.length - 1 && column != 0) {

            if (cells[row + 1][column - 1].getState()) {

                howManyTimes++;
            }

        }


        if (row != cells.length - 1 && column != cells[row].length - 1) {

            if (cells[row + 1][column + 1].getState()) {

                howManyTimes++;
            }

        }


        return howManyTimes;
    }

    public Board applayChangedStateOfCellsOnTheBoard(Board board) {

        Cell[][] cells = board.getCells();

        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {

                boolean newState = cells[row][column].getNewState();
                cells[row][column].activeState(newState);

            }
        }

        return board;

    }

}
