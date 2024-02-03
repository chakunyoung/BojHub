const fs = require("fs");
let input = fs.readFileSync("./dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map((num) => parseInt(num, 10));
const arr = input[1].split(" ").sort((a, b) => a.localeCompare(b));

const temp = [];
const s = "aeiou";

let ans = "";
recur(0, 0);
console.log(ans);

function recur(now, st) {
  if (now == n) {
    let m = 0;
    let j = temp.length;

    for (let ele of temp) {
      for (let spell of s) {
        if (ele == spell) ++m;
      }
    }
    j -= m;
    if (m > 0 && j > 1) ans += `${temp.join("")}\n`;
    return;
  }

  for (let i = st; i < arr.length; i++) {
    temp[now] = arr[i];
    recur(now + 1, i + 1);
  }
}
