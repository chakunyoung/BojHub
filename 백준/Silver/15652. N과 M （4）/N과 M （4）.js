let input = require('fs').readFileSync('./dev/stdin').toString().trim().split('\n');

let [n, m] = input[0].split(" ").map(n=> parseInt(n));

let ans = [];
let temp = [];
recur(0, m, 1);
console.log(ans);

function recur(e, limit, s){
    if(e == limit)
        return ans += `${temp.join(" ")}\n`;

    for(let i = s; i<=n; i++){
        temp[e] = i;
        recur(e + 1, limit, i);
    }
}
