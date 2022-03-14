package pl.karpowicz.game_of_life.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.karpowicz.game_of_life.model.Board;
import pl.karpowicz.game_of_life.model.Cell;
import pl.karpowicz.game_of_life.service.BoardService;

@RestController
@CrossOrigin
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/next-step")
    ResponseEntity<Cell[][]> setBoard(@RequestBody Cell[][] cells) {

        Board board = new Board(cells);
        Board boardCells = boardService.nextStep(board);
        return ResponseEntity.ok(board.getCells());

    }

}
