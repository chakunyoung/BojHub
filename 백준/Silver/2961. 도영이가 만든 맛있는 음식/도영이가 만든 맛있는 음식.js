const fs = require("fs");
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n");
const size = parseInt(input[0]);
const arr = input.slice(1).map((line) => line.split(" ").map(Number));

let ans = Infinity;

function recur(n, a, b, c) {
  if (n === size) {
    if (c > 0) {
      const temp = Math.abs(a - b);
      ans = Math.min(ans, temp);
    }
    return;
  }

  recur(n + 1, a * arr[n][0], b + arr[n][1], c + 1);
  recur(n + 1, a, b, c);
}

recur(0, 1, 0, 0);
console.log(ans);
