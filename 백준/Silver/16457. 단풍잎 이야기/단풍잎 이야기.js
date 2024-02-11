let input = require("fs")
  .readFileSync("./dev/stdin")
  .toString()
  .trim()
  .split("\n");
let [n, m, k] = input[0].split(" ").map(Number);
let v = input.slice(1).map((line) => line.split(" ").map(Number));

let ans = 0;
let temp = [];

function recur(idx, cnt) {
  if (cnt === n) {
    //console.log(temp);
    let c = 0;
    for (let i = 0; i < m; i++) {
      let flag = true;
      for (let j = 0; j < k; j++) {
        if (!temp.includes(v[i][j])) {
          flag = false;
          break;
        }
      }
      if (flag) c++;
    }
    ans = Math.max(ans, c);
    return;
  }

  for (let i = idx; i <= 2 * n; i++) {
    temp.push(i);
    recur(i + 1, cnt + 1);
    temp.pop();
  }
}
recur(1, 0);
console.log(ans);
