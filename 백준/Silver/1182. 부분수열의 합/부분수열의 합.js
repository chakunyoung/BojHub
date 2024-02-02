const fs = require("fs");
let input = fs.readFileSync("./dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map((num) => parseInt(num, 10));
const arr = input[1].split(" ").map((n) => parseInt(n));

let count = 0;
recur(0, 0, 0);
console.log(count);

function recur(now, sum, selected) {
  if (now == n) {
    if (sum == m && selected > 0) ++count;
    return;
  }

  recur(now + 1, sum + arr[now], selected + 1);
  recur(now + 1, sum, selected);
}
