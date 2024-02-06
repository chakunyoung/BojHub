let input = require("fs")
   .readFileSync("./dev/stdin")
   .toString()
   .trim()
   .split("\n");

let num = input[0];

const recur = (n, count) => {
   if (n.length == 1) {
      n = n % 3 == 0 ? "YES" : "NO";
      return { n, count };
   }

   const temp = n.split("").map((e) => parseInt(e));
   let sum = 0;
   for (let ele of temp) sum += ele;
   return recur(String(sum), count + 1);
};

const { n, count } = recur(num, 0);
console.log(count);
console.log(n);
