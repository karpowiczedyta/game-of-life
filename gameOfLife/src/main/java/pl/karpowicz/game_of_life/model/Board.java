package pl.karpowicz.game_of_life.model;

import org.springframework.stereotype.Component;

//@Component
public class Board {

    private Cell[][] cells;

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

}
