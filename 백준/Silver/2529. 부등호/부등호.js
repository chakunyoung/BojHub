let input = require('fs').readFileSync('./dev/stdin').toString().trim().split('\n');

let size = parseInt(input[0]);
const eq = Array.from(input[1].split(" "));

const v = [];
const temp = [];
let max = 0;
let min = Number.MAX_SAFE_INTEGER;
for(let i = 0; i<=9; i++){
    v[i] = true;
    temp[0] = i;
    recur(0, size);    
    v[i] = false;
}

console.log(String(max).padStart(size + 1, 0));
console.log(String(min).padStart(size + 1, 0))

function recur(n , limit){
    if(n == limit){
        let number = parseInt(`${temp.join("")}\n`);
        max = Math.max(max, number);
        min = Math.min(min, number);
        return;
    }

    for(let i = 0; i<=9; i++){
        let eqEle = eq[n];

        if(eqEle =='<' && i > temp[n]){
            if(v[i]) continue;
            v[i] = true;
            temp[n + 1] = i;
            recur(n + 1, limit);
            v[i] = false;

        }else if(eqEle == '>' && i < temp[n]){ // >
            if(v[i]) continue;
            v[i] = true;
            temp[n+1] = i;
            recur(n + 1, limit);
            v[i] = false
        }
    }
}