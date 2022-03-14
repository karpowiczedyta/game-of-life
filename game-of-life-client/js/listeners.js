import {
  clearBoard,
  drawNewBoard,
  cells,
  initialArray,
  drawBoard,
} from "./board.js";
import { square, getDimension, getSpeed, speed } from "./grid-size.js";
import { getNextStep } from "./api.js";

const board = document.getElementById("board");
const context = board.getContext("2d");
let amountNextStep = 0;

function assignNewCell(oldCells, newCells) {
  oldCells.forEach((row, i) => {
    row.forEach((cell, j) => {
      cell.state = newCells[i][j].state;
    });
  });
}

board.addEventListener("click", function (event) {
  const x = Math.floor((event.clientX - 8) / square);
  const y = Math.floor((event.clientY - 90.367) / square);
  cells[y][x].state = true;
  initialArray[y][x].state = true;
  context.fillRect(x * square, y * square, square, square);
});

const nextStepButton = document.getElementById("next-step");
nextStepButton.addEventListener("click", async function () {
  clearBoard();

  drawBoard();

  const nextStateCells = await getNextStep(cells);
  assignNewCell(cells, nextStateCells);

  drawNewBoard();

  amountNextStep++;

  document.getElementById("amountNextStep").innerHTML = amountNextStep;
});

const clearButton = document.getElementById("clear");
clearButton.addEventListener("click", function () {
  clearBoard();

  drawBoard();

  assignNewCell(cells, initialArray);

  drawNewBoard();

  amountNextStep = 0;

  document.getElementById("amountNextStep").innerHTML = amountNextStep;
});

let ifFirst = 0;
let timmerId = 0;
const startButton = document.getElementById("start");
const btnStart = document.querySelector("start");
startButton.addEventListener("click", async function () {
  if (startButton.className == "start") {
    timmerId = setInterval(delayDrawNewBoard, speed);
    startButton.className = "stop";
    this.innerHTML = '<i class="fas fa-pause"></i> STOP';
  } else {
    clearInterval(timmerId);
    startButton.className = "start";
    this.innerHTML = '<i class="fas fa-play"></i>Start';
  }
});

const speedInput = document.getElementById("speed");
speedInput.addEventListener("change", async function (e) {
  if (startButton.className == "stop") {
    clearInterval(timmerId);
    getSpeed(e.target.value);
    timmerId = setInterval(delayDrawNewBoard, speed);
  } else {
    getSpeed(e.target.value);
  }
});

const changeSizeGrid = document.getElementById("size");
changeSizeGrid.addEventListener(
  "input",
  function (e) {
    const value = e.target.value;
    getDimension(value);
    drawBoard();
  },
  true
);

const amountNextStepInput = document.getElementById("amountNextStep");
export async function delayDrawNewBoard() {
  clearBoard();

  drawBoard();

  const nextStateCells = await getNextStep(cells);
  assignNewCell(cells, nextStateCells);

  drawNewBoard();

  amountNextStep++;

  document.getElementById("amountNextStep").innerHTML = amountNextStep;
}
