import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			int size = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();

			int sum = 0;
			int maxNum = 0;
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				sum += num;
				list.add(num);
				maxNum = Math.max(maxNum, num);
			}

			if (sum == 0) {
				sb.append("0\n");
				continue;
			}

			List<Integer> divisorList = new ArrayList<>();
			for (int i = 1; i * i <= sum; i++) {
				if (sum % i == 0) {
					if (sum / i == i) {
						divisorList.add(i);
					} else {
						divisorList.add(i);
						divisorList.add(sum / i);
					}
				}
			}

			Collections.sort(divisorList);

			int min = Integer.MAX_VALUE;
			for (int divisor : divisorList) {
				int tempSum = 0, count = 0;
				boolean check = true;

				for (int num : list) {
					tempSum += num;
					if (tempSum > divisor) {
						check = false;
						break;
					}
					if (tempSum == divisor) {
						tempSum = 0;
						count++;
					}
				}

				if (check && tempSum == 0) {
					min = Math.min(min, size - count);
				}
			}
			sb.append(min).append('\n');
		}
		System.out.println(sb);
	}
}