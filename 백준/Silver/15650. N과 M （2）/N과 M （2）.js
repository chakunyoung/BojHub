const fs = require("fs");
let input = fs.readFileSync("./dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map((num) => parseInt(num, 10));
const arr = new Array();
const temp = new Array();
const v = new Array();
let ans = [];

recur(0, m, 1);
console.log(ans);

function recur(now, limit, s) {
  if (now == limit) {
  
    return (ans += `${temp.join(" ")}\n`);
  }

  for (let i = s; i <= n; i++) {
    //if (v[i]) continue;
    //v[i] = true;
    temp[now] = i;
    recur(now + 1, limit, i + 1);
    //v[i] = false;
  }
}
