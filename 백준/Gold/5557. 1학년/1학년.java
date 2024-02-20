import java.io.*;
import java.util.*;

public class Main {

	static int size;
	static int[] arr;
	static int lastNum;
	static long[][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		size = Integer.parseInt(br.readLine()) - 1;
		st = new StringTokenizer(br.readLine());

		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		lastNum = Integer.parseInt(st.nextToken());

		memo = new long[size][21];
		for (long[] row : memo)
			Arrays.fill(row, -1);

		System.out.println(recur(0, arr[0]));
	}

	static long recur(int n, int v) {
		if (v < 0 || v > 20)
			return 0;
		if (n == size - 1) {
			return v == lastNum ? 1 : 0;
		}
		if (memo[n][v] != -1)
			return memo[n][v];

		long res1 = recur(n + 1, v + arr[n + 1]);
		long res2 = recur(n + 1, v - arr[n + 1]);

		return memo[n][v] = res1 + res2;
	}
}
