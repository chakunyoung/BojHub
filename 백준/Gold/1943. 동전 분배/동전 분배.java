import java.io.*;
import java.util.*;

public class Main {
	static int[][] memo;
	static Coin[] coin;
	static int total;
	static boolean f = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int i = 0; i < 3; i++) {
			int n = Integer.parseInt(br.readLine());
			coin = new Coin[n];
			int tcs = 0;
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int vv = Integer.parseInt(st.nextToken());
				int coinCount = Integer.parseInt(st.nextToken());
				tcs += coinCount;
				coin[j] = new Coin(vv, coinCount);
			}

			total = 0;
			for (int j = 0; j < coin.length; j++) {
				total += coin[j].count * coin[j].v;
			}

			memo = new int[(total) / 2 + 1][n + 1];

			for (int[] a : memo)
				Arrays.fill(a, -1);

			if (total % 2 == 1) {
				sb.append("0").append("\n");
				continue;
			}

			int res = recur(0, 0);
			sb.append(res > 0 ? 1 : 0).append("\n");
			f = false;
		}
		System.out.println(sb);
	}

	static int recur(int idx, int v) {
		if (v == total / 2) {
			f = true;
			return 1;
		}

		if (v > total / 2) {
			return 0;
		}

		if (memo[v][idx] != -1)
			return memo[v][idx];

		int res = 0;
		for (int i = 0; i < coin.length; i++) {
			if (f)
				return 1;

			if (coin[i].count > 0) {
				coin[i].count--;
				res += recur(i, v + coin[i].v);
				coin[i].count++;
			}
		}
		return memo[v][idx] = res;
	}

	static class Coin {
		int v, count;

		public Coin(int v, int count) {
			this.v = v;
			this.count = count;
		}
	}
}
