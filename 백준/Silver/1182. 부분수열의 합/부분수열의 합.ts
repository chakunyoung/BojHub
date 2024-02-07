let input = require("fs")
   .readFileSync("./dev/stdin")
   .toString()
   .trim()
   .split("\n");

let s: number, t: number;
[s, t] = input[0].split(" ").map((n: string) => parseInt(n));
const arr: number[] = input[1].split(" ").map((n: string) => parseInt(n));

let ans: number = 0;

const recur = (n: number, c: number, sum: number) => {
   if (n == s) {
      if (c > 0 && sum == t) ++ans;
      return;
   }
   recur(n + 1, c + 1, sum + arr[n]);
   recur(n + 1, c, sum);
};
recur(0, 0, 0);
console.log(ans);
