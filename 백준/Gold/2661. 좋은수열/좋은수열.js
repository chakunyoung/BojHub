const fs = require("fs");
let input = fs.readFileSync("./dev/stdin").toString().split("\n");

//const [n, m] = input[0].split(" ").map((num) => parseInt(num));
let n = parseInt(input[0]);
const temp = [];

let ans = "";
let flag = false;
recur(0, 0);
console.log(ans);

// 추가 뒤 숫자만 검사
function recur(now) {
  if (flag) return;

  if (now > 1) {
    let halfSize = parseInt(now / 2);
    for (let i = halfSize; i > 0; i--) {
      let count = 0;
      let e = now - 1;
      let s = now - 1 - i;

      for (let j = 0; j < i; j++) {
        if (temp[e] == temp[s]) ++count;
        e--;
        s--;
      }
      if (count == i) return;
    }
  }

  if (now == n) {
    ans += `${temp.join("")}`;
    flag = true;
    return;
  }

  for (let i = 1; i <= 3; i++) {
    temp[now] = i;
    recur(now + 1);
  }
}
