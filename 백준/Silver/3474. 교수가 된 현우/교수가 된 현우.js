const fs = require("fs");
const input = fs
  .readFileSync("./dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .slice(1);

let ans = [];
function f(N) {
  let count = 0;
  for (let i = 5; N / i >= 1; i *= 5) {
    count += Math.floor(N / i);
  }
  return count;
}

input.forEach((N) => {
  ans.push(f(parseInt(N)));
});
console.log(ans.join("\n"));
