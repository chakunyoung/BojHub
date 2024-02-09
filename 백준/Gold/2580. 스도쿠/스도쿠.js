const fs = require("fs");
const input = fs
  .readFileSync("./dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((row) => row.split(" ").map(Number));

const arr = input.slice(0, 9);
let flag = false;

function recur(idx) {
  if (flag) return;

  if (idx === 81) {
    arr.forEach((row) => console.log(row.join(" ")));
    flag = true;
    return;
  }

  const x = Math.floor(idx / 9);
  const y = idx % 9;

  if (arr[x][y] != 0) {
    recur(idx + 1);
  } else {
    for (let num = 1; num <= 9; num++) {
      if (check(x, y, num)) {
        arr[x][y] = num;
        recur(idx + 1);
        arr[x][y] = 0;
      }
    }
  }
}

function check(x, y, num) {
  for (let i = 0; i < 9; i++) {
    if (arr[x][i] === num || arr[i][y] === num) {
      return false;
    }
  }

  const dx = Math.floor(x / 3) * 3;
  const dy = Math.floor(y / 3) * 3;

  for (let i = dx; i < dx + 3; i++) {
    for (let j = dy; j < dy + 3; j++) {
      if (arr[i][j] === num) {
        return false;
      }
    }
  }

  return true;
}

recur(0);
