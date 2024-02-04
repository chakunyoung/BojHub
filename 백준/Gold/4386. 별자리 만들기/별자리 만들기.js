const fs = require("fs");
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n");
const n = parseInt(input[0]);
const stars = input.slice(1, n + 1).map((line) => line.split(" ").map(Number));
const parent = Array.from({ length: n }, (_, i) => i);
const edges = [];

for (let i = 0; i < n; i++) {
  for (let j = i + 1; j < n; j++) {
    edges.push([distance(stars[i], stars[j]), i, j]);
  }
}
edges.sort((a, b) => a[0] - b[0]);

let result = 0;
for (const [cost, a, b] of edges) {
  if (find(parent, a) !== find(parent, b)) {
    union(parent, a, b);
    result += cost;
  }
}
console.log(result.toFixed(2));

function find(parent, x) {
  if (parent[x] === x) return x;
  return (parent[x] = find(parent, parent[x]));
}

function union(parent, a, b) {
  a = find(parent, a);
  b = find(parent, b);
  if (a < b) parent[b] = a;
  else parent[a] = b;
}

function distance(s1, s2) {
  return Math.sqrt(Math.pow(s1[0] - s2[0], 2) + Math.pow(s1[1] - s2[1], 2));
}
