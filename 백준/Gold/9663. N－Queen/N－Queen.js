const fs = require("fs");
let input = fs.readFileSync("./dev/stdin").toString().split("\n");

const size = parseInt(input[0]);

const v = [];
const temp = [];

let ans = 0;
recur(0);
console.log(ans);

function recur(n) {
  if (n == size) {
    ++ans;
    return;
  }

  l: for (let i = 0; i < size; i++) {
    if (v[i]) continue;

    for (let j = 0; j < n; j++) {
      if (Math.abs(n - j) === Math.abs(i - temp[j])) {
        continue l;
      }
    }

    v[i] = true;
    temp[n] = i;
    recur(n + 1);
    v[i] = false;
  }
}