import { Cell } from "../model/cell.js";
import { square, lengthx } from "./grid-size.js";

const context = board.getContext("2d");
let lengthy = 0;

export function drawBoard() {
  let x = 0;
  let y = 0;
  context.clearRect(0, 0, board.width, board.height);

  for (let i = 0; i < lengthx; i++) {
    y = y + square;
    if (y <= 635) {
      lengthy++;
      context.beginPath();
      context.moveTo(0, y);
      context.lineTo(1836, y);
      context.stroke();
    }
  }

  for (let i = 0; i < lengthx; i++) {
    x = x + square;
    context.beginPath();
    context.moveTo(x, 0);
    context.lineTo(x, 634);
    context.stroke();
  }

  // console.log("siemka");
  // console.log(moment().startOf("day"));
  // console.log(moment().endOf("day"));
}

drawBoard();

export let cells = new Array();
export let initialArray = new Array();

for (let row = 0; row < lengthy; row++) {
  cells.push([]);
  for (let column = 0; column < lengthx; column++) {
    cells[row][column] = new Cell(false, false);
  }
}

for (let row = 0; row < lengthy; row++) {
  initialArray.push([]);
  for (let column = 0; column < lengthx; column++) {
    initialArray[row][column] = new Cell(false, false);
  }
}

export function clearBoard() {
  for (let row = 0; row < cells.length; row++) {
    for (let column = 0; column < cells[row].length; column++) {
      if (cells[row][column].state === true) {
        context.clearRect(0, 0, board.width, board.height);
      }
    }
  }
}

export function drawNewBoard() {
  for (let row = 0; row < cells.length; row++) {
    for (let column = 0; column < cells[row].length; column++) {
      if (cells[row][column].state === true) {
        context.fillRect(column * square, row * square, square, square);
      }
    }
  }
}
