import java.io.*;
import java.util.*;

public class Main {
	static int size;
	static int[][] arr;
	static int[][] memo;
	static int[][] memo2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		size = Integer.parseInt(br.readLine());

		arr = new int[size][3];
		memo = new int[size][3];
		memo2 = new int[size][3];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < size; i++) {
			Arrays.fill(memo[i], -1);
			Arrays.fill(memo2[i], -1);
		}

		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++)
			max = Math.max(max, recur(0, i));

		for (int i = 0; i < 3; i++)
			min = Math.min(min, recur2(0, i));

		System.out.println(max + " " + min);
	}

	static int recur(int n, int prev) {
		if (n == size)
			return 0;

		if (memo[n][prev] != -1) {
			return memo[n][prev];
		}

		int max = 0;
		int s = 0;
		int e = 2;

		if (prev == 0)
			e = 1;
		else if (prev == 2)
			s = 1;

		for (int i = s; i <= e; i++) {
			max = Math.max(max, recur(n + 1, i) + arr[n][prev]);
		}

		return memo[n][prev] = max;
	}

	static int recur2(int n, int prev) {
		if (n == size)
			return 0;

		if (memo2[n][prev] != -1) {
			return memo2[n][prev];
		}

		int min = Integer.MAX_VALUE;
		int s = 0;
		int e = 2;

		if (prev == 0)
			e = 1;
		else if (prev == 2)
			s = 1;

		for (int i = s; i <= e; i++) {
			min = Math.min(min, recur2(n + 1, i) + arr[n][prev]);
		}
		return memo2[n][prev] = min;
	}
}