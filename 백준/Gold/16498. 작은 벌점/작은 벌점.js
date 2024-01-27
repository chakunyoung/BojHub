// 정렬을 안했다

const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let [s1, s2, s3] = input[0].split(" ").map(Number);
let arr1 = input[1]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);
let arr2 = input[2]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);
let arr3 = input[3]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

let arrGroup = [arr1, arr2, arr3];
let ans = Number.MAX_SAFE_INTEGER;
for (let i = 0; i < 2; i++) {
  for (let j = i + 1; j <= 2; j++) {
    let comArr1 = arrGroup[i];
    let comArr2 = arrGroup[j];
    let comArr3 = arrGroup[3 - i - j];

    ans = Math.min(ans, bs(comArr1, comArr2, comArr3));
  }
}

console.log(parseInt(ans));

function bs(arr1, arr2, arr3) {
  let value = Number.MAX_SAFE_INTEGER;

  for (let i = 0; i < arr1.length; i++) {
    for (let j = 0; j < arr2.length; j++) {
      let min = Math.min(arr1[i], arr2[j]);
      let max = Math.max(arr1[i], arr2[j]);
      let gap = max - min;

      let s = 0;
      let e = arr3.length - 1;

      while (s <= e) {
        let mid = parseInt((s + e) / 2);
        let element = arr3[mid];

        if (element < min) {
          s = mid + 1;
        } else if (element > max) {
          e = mid - 1;
        } else {
          value = Math.min(value, Math.abs(gap));
          break;
        }
      }
    }
  }

  return value;
}
