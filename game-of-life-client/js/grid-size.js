const value = document.getElementById("size").value;
let width = 1836;
let height = 640;
export let square = 0;
export let lengthx = 0;
export let speed = 1000;

getDimension(value);

export function getDimension(value) {
  const intValue = parseInt(value);
  switch (intValue) {
    case 0:
      lengthx = 230;
      square = 1836 / 230;
      break;
    case 10:
      lengthx = 220;
      square = 1836 / 220;
      break;
    case 20:
      lengthx = 200;
      square = 1836 / 200;
      break;
    case 30:
      lengthx = 180;
      square = 1836 / 180;
      break;
    case 40:
      lengthx = 160;
      square = 1836 / 160;
      break;
    case 50:
      lengthx = 130;
      square = 1836 / 130;
      break;
    case 60:
      lengthx = 110;
      square = 1836 / 110;
      break;
    case 70:
      lengthx = 80;
      square = 1836 / 80;
      break;
    case 80:
      lengthx = 60;
      square = 1836 / 60;
      break;
    case 90:
      lengthx = 40;
      square = 1836 / 40;
      break;
    case 100:
      lengthx = 30;
      square = 1836 / 30;
      break;
    default:
      alert("there is no such value");
  }
}

export function getSpeed(value) {
  const intValue = parseInt(value);
  switch (intValue) {
    case 0:
      speed = 1700;
      break;
    case 10:
      speed = 1550;
      break;
    case 20:
      speed = 1500;
      break;
    case 30:
      speed = 1350;
      break;
    case 40:
      speed = 1100;
      break;
    case 50:
      speed = 1000;
      break;
    case 60:
      speed = 900;
      break;
    case 70:
      speed = 700;
      break;
    case 80:
      speed = 600;
      break;
    case 90:
      speed = 500;
      break;
    case 100:
      speed = 300;
      break;
    default:
      alert("there is no such value");
  }
}
