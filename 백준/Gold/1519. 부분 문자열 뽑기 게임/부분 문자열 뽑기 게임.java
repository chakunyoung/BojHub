import java.awt.List;
import java.io.*;
import java.util.*;

public class Main {

	static int[] memo;
	static int min = Integer.MAX_VALUE;
	static int v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		v = n;

		memo = new int[n + 1];
		Arrays.fill(memo, -1);

		System.out.println(recur(n) == 0 ? "-1" : min);
	}

	static int recur(int n) {
		if (memo[n] != -1)
			return memo[n];

		int count = 0;

		String strn = String.valueOf(n);
		for (int i = strn.length(); i > 0; i--) {
			for (int j = 0; j <= strn.length() - i; j++) {
				int temp = Integer.parseInt(strn.substring(j, j + i));

				if (temp == 0 || temp == n)
					continue;

				if (n - temp >= 0 && recur(n - temp) == 0) {
					if (n == v)
						min = Math.min(min, temp);
					count++;
				}
			}
		}

		if (count > 0) {
			return memo[n] = 1;
		} else
			return memo[n] = 0;
	}
}
